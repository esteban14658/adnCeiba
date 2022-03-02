insert into usuario(id, nombre,clave,fecha_creacion) values(1,'test','1234',now());
insert into jugador (documento, nombre, apellido, fecha_nacimiento, peso, altura, posicion, pie_habil)
values (80808080, 'Juanito', 'Perez', now(), 45.6, 1.65, 'Delantero', 'Derecho');
insert into factura (valor, fecha_ingreso, fecha_caducidad, jugador, estado, descripcion)
values ('420000', now(), '2022-06-01', 1, 1, 'Tres meses')