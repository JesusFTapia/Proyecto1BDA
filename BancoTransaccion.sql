
delimiter #
create procedure transferencia_transaccion(in ice int, in icr int, in nce int, in ncr int,in m float)
begin
	declare saldoOrigen float(10, 2);
    declare saldoDestino float(10, 2);
    declare exit handler for sqlexception
    begin
        rollback;
	end;
    start transaction;
    select saldo into saldoOrigen from cuentas where numeroCuenta = nce;
    select saldo into saldoDestino from cuentas where numeroCuenta = ncr;
    if(saldoOrigen>=m)then
		update cuentas set saldo = saldoOrigen - m where numeroCuenta = nce;
		update cuentas set saldo = saldoDestino + m where numeroCuenta = ncr;
		insert into transferencias (idcuentaenvia, idcuentarecibe, numerocuentaenvia, numerocuentarecibe,monto, fecha) values (ice, icr,nce, ncr,m, curdate());
        commit;
    end if;
end #
delimiter ;


delimiter $$
create procedure generar_retiro(in id int,in folio int,in m float,in contra varchar(8))
begin
	declare saldoCuenta float(10, 2);
    declare exit handler for sqlexception
    begin
        rollback;
	end;
    start transaction;
    select saldo into saldoCuenta from cuentas where idcuenta = id;
    if(saldoCuenta>=m)then
		update cuentas set saldo = saldoCuenta - m where idcuenta = id;
		insert into retirossincuenta(idcuenta ,folio, saldo,contrasena,estado,fechainicio,fechaExpiracion) values(id,folio,m, contra,"No cobrado",now(), DATE_ADD(now(), INTERVAL 10 MINUTE));
        commit;
    end if;
end $$
delimiter ;


delimiter !!
create procedure cobrar_retiro(in id int,in contra varchar(8))
begin
	declare fechaExp datetime;
    declare estadoE varchar(10);
    declare exit handler for sqlexception
    begin
        rollback;
	end;
    start transaction;
    select fechaExpiracion into fechaExp from retirossincuenta where folio = id and contrasena=contra;
    select estado into estadoE from retirossincuenta where folio = id and contrasena=contra;
    if(fechaExp>now() and estadoE="No cobrado")then
		update retirossincuenta set estado="Cobrado" where folio = id;
        commit;
    end if;
	if (fechaExp<now() or estadoE="Cobrado")then
        signal sqlstate '45000'
        set message_text = 'El retiro ha expirado';
    end if;
end !!
delimiter ;