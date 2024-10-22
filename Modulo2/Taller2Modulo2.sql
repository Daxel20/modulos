/*Taller Modulo2*/
/*Taller 1*/
create database VentasComercioElectronico;
use VentasComercioElectronico;

create table departamento(
id int not null auto_increment,
nombre varchar(45),
constraint primary key(id)
);

create table empleado(
id int not null auto_increment,
nombre varchar (45) not null,
apellido varchar(45),
edad varchar(45),
fechaInscripcion datetime default current_timestamp (),
departamento_id int not null,
constraint primary key(id),
constraint fk_departamento foreign key(departamento_id) references departamento(id)
on update cascade on delete cascade
);

create table cliente(
id int not null auto_increment,
nombre varchar (45) not null,
apellido varchar(45),
cedula varchar(45),
direccion varchar(45),
email varchar(45),
constraint primary key(id)
);

create table producto(
id int not null auto_increment,
nombre varchar(45),
cantidad varchar(45),
precio varchar(45),
constraint primary key(id)
);

create table factura(
id_factura int not null auto_increment,
id_cliente int not null,
id_producto int not null,
fecha datetime default current_timestamp (),
descripcion varchar(45),
total varchar(45),
constraint primary key (id_factura,id_cliente,id_producto),
constraint fk_cliente foreign key(id_cliente) references cliente(id)
on update cascade on delete cascade,
constraint fk_producto foreign key(id_producto) references producto(id)
on update cascade on delete cascade
);

insert into departamento (nombre)
values 
('Recursos Humanos'),
('Marketing'),
('Ventas'),
('Desarrollo');

insert into empleado (nombre, apellido, edad, departamento_id)
values 
('Andy', 'Granda', '35', 1),
('Isaac', 'Villasic', '28', 2),
('Oscar', 'Prado', '40', 3),
('María', 'Fernández', '30', 4);

insert into cliente (nombre, apellido, cedula, direccion, email)
values 
('Luis', 'Torres', '1712345678', 'Calle Falsa 123', 'luistorres@mail.com'),
('Laura', 'Martínez', '1712348765', 'Av. Real 456', 'lauramartinez@mail.com'),
('Pedro', 'García', '1712349876', 'Calle Verdad 789', 'pedrogarcia@mail.com');

insert into producto (nombre, cantidad, precio)
values 
('Computadora', '10', '1500'),
('Impresora', '5', '300'),
('Teléfono', '20', '700');

INSERT INTO factura (id_cliente, id_producto, descripcion, total)
VALUES 
(1, 1, 'Compra de Computadora', '1500'),
(2, 3, 'Compra de Impresora', '300'),
(3, 2, 'Compra de Teléfono', '700');

/*CONSULTAS MULTITABLA*/
/*Obtener la información de los empleados junto con el nombre de su departamento*/
select e.nombre as Empleado, e.apellido as Apellido, d.nombre as Departamento
from empleado e
join departamento d on e.departamento_id = d.id;

/*Consulta las facturas junto con el nombre del cliente y el nombre del producto*/
select f.id_factura, c.nombre AS Cliente, p.nombre AS Producto, f.total
from factura f
join cliente c on f.id_cliente = c.id
join producto p on f.id_producto = p.id;

/*Consulta para obtener todos los empleados que trabajan en un departamento específico */
select e.nombre as Empleado, e.apellido as Apellido, d.nombre as Departamento
from empleado e
join departamento d on e.departamento_id = d.id
where d.nombre = 'Ventas';

/*Subconsultas Escalonadas*/
/*Obtener el nombre del departamento al que pertenece un empleado específico*/
select nombre 
from departamento 
where id = (
    select departamento_id 
    from empleado 
    where nombre = 'Isaac' and apellido = 'Villasic'
);

/*Encontrar el nombre del cliente que ha gastado más dinero en sus compras*/
select nombre 
from cliente 
where id = (
    select id_cliente 
    from factura 
    order by total desc 
    limit 1
);

/*Obtener el producto más vendido basado en la cantidad de facturas*/
select nombre 
from producto 
where id = (
    select id_producto 
    from factura 
    group by id_producto 
    order by COUNT(*) desc 
    limit 1
);

/*TALLER 2*/
/*Crear tres vistas con la información pertinente de acuerdo al giro de negocio*/
/*1.Vista de clientes y sus facturas*/
create view vista_clientes_facturas as
select c.nombre, c.apellido, c.cedula, f.descripcion, f.total, f.fecha
from cliente c
join factura f on c.id = f.id_cliente;

/*2.Empleados por departamento*/
create view vista_empleados_departamento as
select e.nombre as nombre_empleado, e.apellido, d.nombre as nombre_departamento
from empleado e
join departamento d on e.departamento_id = d.id;

/*3.Vista de productos más vendidos*/
create view vista_productos_vendidos as
select p.nombre as nombre_producto, sum(f.total) as total_vendido
from producto p
join factura f on p.id = f.id_producto
group by p.nombre;

/*Crear 3 usuarios asignar los privilegios oportunos y necesarios.*/
/*1.Usuario solo lectura*/
create user 'lectura'@'localhost' identified by 'lectura123';
grant select on *.* to 'lectura'@'localhost';

/*2.Usuario con permisos de inserción y actualización*/
create user 'editor'@'localhost' identified by 'editor123';
grant insert, update on *.* to 'editor'@'localhost';

/*3.Usuario con todos los privilegios*/
create user 'admin'@'localhost' identified by 'admin123';
grant all privileges on *.* to 'admin'@'localhost';

/* Crear 3 triggers como mecanismos de control y auditoría*/
CREATE TABLE auditoria (
    id int not null auto_increment,
    accion varchar(45),
    descripcion text,
    fecha datetime default current_timestamp,
    primary key (id)
);

/*1.Trigger para registrar la inserción de un nuevo empleado*/
DELIMITER //
create trigger registro_nuevo_empleado
after insert on empleado
for each row
begin
    insert into auditoria (accion, descripcion, fecha) 
    values ('INSERT', concat('Nuevo empleado: ', new.nombre, ' ', new.apellido), now());
end //
DELIMITER ;
insert into empleado (nombre, apellido, edad, departamento_id)
values ('Damian', 'Pérez', '30', 1);

/*2.Trigger para registrar la eliminación de facturas*/
DELIMITER //
create trigger registro_eliminacion_factura
after delete on factura
for each row
Begin
    insert into auditoria (accion, descripcion, fecha) 
    values ('DELETE', CONCAT('Factura eliminada, ID: ', old.id_factura, ', Cliente: ', old.id_cliente, ', Producto: ', OLD.id_producto), NOW());
end //
DELIMITER ;
delete from factura 
where id_factura = 1 and id_cliente = 1 and id_producto = 1;

select * from auditoria;

/*3.Trigger para controlar inserciones en la tabla empleado*/
DELIMITER //
create trigger control_insercion_empleado
before insert on empleado
for each row
begin
    if new.edad < 18 then
        signal sqlstate '45000'
        set message_text = 'No se puede insertar un empleado menor de 18 años.';
    end if;
end //
DELIMITER ;
insert into empleado (nombre, apellido, edad, departamento_id) 
values ('Juan', 'Pérez', 20, 1);

/*Crear cinco procedimientos almacenados*/
/*1.Insertar un nuevo cliente*/
DELIMITER //
create procedure insertar_cliente(in nombre_cliente varchar(45), in apellido_cliente varchar(45), 
in cedula_cliente varchar(45), in direccion_cliente varchar(45), in email_cliente varchar(45))
begin
    insert into cliente (nombre, apellido, cedula, direccion, email)
    values (nombre_cliente, apellido_cliente, cedula_cliente, direccion_cliente, email_cliente);
end //
DELIMITER ;
call insertar_cliente('Emili', 'Cano', '1234567890', 'Calle Falsa 123', 'cano@gmail.com');

/*2.Actualizar stock de productos*/
DELIMITER //
create procedure actualizar_stock(in id_producto int, in nueva_cantidad int)
begin
    update producto
    set cantidad = nueva_cantidad
    where id = id_producto;
end//
DELIMITER ;
call actualizar_stock(1, 200);

/*3.Generar reporte de facturas por cliente*/
DELIMITER //
create procedure reporte_facturas_cliente(in id_cliente int)
begin
    select f.id_factura, f.descripcion, f.total, f.fecha
    from factura f
    where f.id_cliente = id_cliente;
end//
DELIMITER ;
call reporte_facturas_cliente(1);

/*4.Actualizar datos de un empleado*/
DELIMITER //
create procedure actualizar_empleado(in id_empleado int, in nuevo_nombre varchar(45), 
in nuevo_apellido varchar(45), in nueva_edad varchar(45))
begin
    update empleado
    set nombre = nuevo_nombre, apellido = nuevo_apellido, edad = nueva_edad
    where id = id_empleado;
end//
DELIMITER ;
call actualizar_empleado(1, 'Carlos', 'Gómez', '35');

/*5.Eliminar cliente por cédula*/
DELIMITER //
create procedure eliminar_cliente_por_cedula(in cedula_cliente varchar(45))
begin
    delete from cliente where cedula = cedula_cliente;
end//
DELIMITER ;
call eliminar_cliente_por_cedula('1234567890');

/*Aplicar indexación con el fin de optimizar las consultas select.*/
/*1.Índice en la tabla factura para el campo id_cliente*/
create index idx_cliente_factura on factura(id_cliente);
select * from factura where id_cliente = 2;

/*2.Índice en la tabla producto para el campo nombre*/
create index idx_nombre_producto on producto(nombre);
select * from producto WHERE nombre = 'Laptop';

/*3. Índice en la tabla cliente para el campo cedula*/
create index idx_cliente_cedula ON cliente(cedula);
select * from cliente where cedula = '1723456789';

/*Crear 2 funciones definidas por el usuario.*/
/*1.Calcular el IVA (12%) sobre un total*/
DELIMITER //
create function calcular_iva(total decimal(10,2))
returns decimal(10,2)
deterministic
begin
    return total * 0.12;
end//
DELIMITER ;
select calcular_iva(SUM(total)) 
from factura;

/*2.Calcular antigüedad de un cliente (en años) desde su primera factura*/
DELIMITER //
CREATE FUNCTION calcular_antiguedad(id_cliente INT)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE antiguedad INT;
    SELECT TIMESTAMPDIFF(YEAR, MIN(fecha), NOW()) INTO antiguedad
    FROM factura
    WHERE id_cliente = id_cliente;
    RETURN antiguedad;
END//
DELIMITER ;
select calcular_antiguedad(3); 
