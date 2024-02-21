delimiter //

create trigger antes_de_agregar_cliente
before insert on clientes
for each row
begin
    declare nombre_repetido int;
    select count(*) into nombre_repetido
    from clientes
    where nombreusuario = new.nombreusuario;
    if nombre_repetido > 0 then
        signal sqlstate '45000'
        set message_text = 'Ese nombre de usuario ya existe';
    end if;
end //

delimiter ;

delimiter $$
create trigger comprobarSiMayorDeEdad
before insert on clientes
for each row
begin
    declare edadCliente int;
    declare fechaNacimiento date;
    set fechaNacimiento = new.fechaNacimiento;
    set edadCliente = timestampdiff(year, fechaNacimiento, curdate());
    if edadCliente < 18 then
        signal sqlstate '45000'
        set message_text = 'La edad del cliente debe ser mayor de 18 años';
    end if;
end $$
delimiter ;