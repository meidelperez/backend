CREATE DATABASE test;
CREATE TABLE cliente (
		matricula varchar(255) not null auto_increment,
		apellidos varchar(255), 
		direccion varchar(255), 
		nombre varchar(255), 
		primary key (matricula)
		);