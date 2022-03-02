create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

CREATE TABLE jugador (
 id INT NOT NULL AUTO_INCREMENT,
 documento INT NOT NULL unique,
 nombre VARCHAR(40) NOT NULL,
 apellido VARCHAR(40) NOT NULL,
 fecha_nacimiento DATE NOT NULL,
 peso FLOAT NOT NULL,
 altura FLOAT NOT NULL,
 posicion VARCHAR(20) NOT NULL,
 pie_habil VARCHAR(20) NOT NULL,
 PRIMARY KEY (id)
);

create table factura (
 id int(11) not null auto_increment,
 valor integer not null,
 fecha_ingreso date not null,
 fecha_caducidad date not null,
 jugador int not null,
 estado bool not null,
 descripcion varchar(100) not null,
 primary key (id),
 foreign key (jugador) references jugador(id)
);