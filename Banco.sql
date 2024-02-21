Create Database banco;
use banco;
 create table clientes(
 idcliente int(10) primary key auto_increment,
 nombre varchar (20),
 nombreUsuario varchar(20),
 apellidoPaterno varchar(20),
 apellidoMaterno varchar(20),
 contrasena varchar(10),
 fechaNacimiento date
 );
 
 create table cuentas(
 idcuenta int(8) primary key auto_increment,
 numeroCuenta int (8),
 idcliente int(10),
 fechaApertura date,
 saldo float,
 estado varchar(10),
 FOREIGN KEY (idcliente) REFERENCES clientes(idcliente)
 );
 create table direcciones(
 idCliente int primary key,
 CodigoPostal varchar(5),
 Calle varchar(20),
 Colonia varchar(20),
 NumeroCasa varchar(4),
 FOREIGN KEY (idcliente) REFERENCES Clientes(idcliente)
 );

 create table transferencias(
 idtransferencia int(8)primary key auto_increment ,
 idcuentaEnvia int(8)not null,
 idcuentaRecibe int(8)not null,
 numeroCuentaEnvia int(8)not null,
 numeroCuentaRecibe int(8)not null,
 monto float not null,
 fecha date not null,
 FOREIGN KEY (idCuentaEnvia) REFERENCES cuentas(idcuenta),
 FOREIGN KEY (idCuentaRecibe) REFERENCES cuentas(idcuenta)
 );
 
 create table retirossincuenta(
 idcuenta int(8),
 folio int(8)primary key auto_increment,
 saldo float,
 contrasena varchar(8),
 estado varchar(10),
 fechainicio datetime,
 fechaExpiracion datetime,
 FOREIGN KEY (idcuenta) REFERENCES cuentas(idcuenta)
 );
INSERT INTO clientes (nombre, nombreUsuario, apellidoPaterno, apellidoMaterno, contrasena, fechaNacimiento) VALUES 
('Alice', 'alice_smith', 'Smith', 'Johnson', 'clave456', '1985-07-22'),
('Bob', 'bob_jones', 'Jones', 'Williams', 'pass789', '1992-04-10'),
('Eva', 'eva_martin', 'Martin', 'Clark', 'secreto123', '1988-12-05');

INSERT INTO cuentas (idcliente,numeroCuenta, fechaApertura, saldo,estado) VALUES
(1,12345678, '2022-01-01', 1000.00,"Activa"),
(2,23456789,'2022-01-15', 2500.00,"Activa"),
(3,34567890,'2022-02-01', 500.00,"Activa");
 INSERT INTO direcciones (idCliente, CodigoPostal, Calle, Colonia, NumeroCasa) VALUES
(1, '12345', 'Calle A', 'Colonia A', '1234'),
(2, '54321', 'Calle B', 'Colonia B', '5678'),
(3, '98765', 'Calle C', 'Colonia C', '9101');
select * from clientes;
select* from direcciones;
SELECT * FROM cuentas;
select* from transferencias;
SELECT * FROM TRANSFERENCIAS WHERE fecha between '2024-02-01' and '2024-02-19';
select * from retirossincuenta;


 