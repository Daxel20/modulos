/*Taller Modulo2*/

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
