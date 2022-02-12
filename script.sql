DROP DATABASE helpme_iud;

-- creamos base de datos
CREATE DATABASE IF NOT EXISTS helpme_iud;

-- seleccionamos
USE helpme_iud;
-- CREACION DE TABLAS

-- tabla de roles

CREATE TABLE IF NOT EXISTS roles(
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    descripcion VARCHAR(45),
    PRIMARY KEY(id)
);

-- tabla de usuarios

CREATE TABLE IF NOT EXISTS usuarios(
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(120) NOT NULL,
    password VARCHAR(120),
    nombre VARCHAR(120) NOT NULL,
    apellido VARCHAR(120),
    fecha_nacimiento DATE,
    enabled TINYINT DEFAULT 1,
    red_social TINYINT DEFAULT 0,
    image VARCHAR(200) NULL DEFAULT 'https://www.weact.org/wp-content/uploads/2016/10/Blank-profile.png',
    PRIMARY KEY(id),
    UNIQUE(username)
);

-- tabla pivote entre roles y usuarios
CREATE TABLE IF NOT EXISTS roles_usuarios(
    usuarios_id INT NOT NULL,
    roles_id INT NOT NULL,
    PRIMARY KEY(usuarios_id, roles_id),
    FOREIGN KEY(usuarios_id) REFERENCES usuarios(id),
    FOREIGN KEY(roles_id) REFERENCES roles(id)
);

-- tabla de delitos
CREATE TABLE IF NOT EXISTS delitos(
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    descripcion VARCHAR(120),
    usuarios_id INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(usuarios_id) REFERENCES usuarios(id)
);

-- tabla de casos
CREATE TABLE IF NOT EXISTS casos(
    id INT NOT NULL AUTO_INCREMENT,
    fecha_hora DATETIME DEFAULT NOW(),
    latitud FLOAT,
    longitud FLOAT,
    altitud FLOAT,
    visible TINYINT,
    descripcion VARCHAR(250),
    url_map TEXT,
    rmi_map TEXT,
    usuarios_id INT NOT NULL,
    delitos_id INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(usuarios_id) REFERENCES usuarios(id),
    FOREIGN KEY(delitos_id) REFERENCES delitos(id)
);

/* LLENADO DE TABLAS */

-- tabla de roles
INSERT INTO roles(nombre, descripcion) 
VALUES('ROLE_ADMIN', 'Administrador del sistema');

INSERT INTO roles(nombre, descripcion)
VALUES('ROLE_USER', 'Usuario normal que registra casos');

-- tabla de usuarios
INSERT INTO usuarios(username, password, nombre, apellido, fecha_nacimiento, enabled, red_social)
VALUES('isotherguy', '$2a$12$zmkfvNAVLgYPcfnX8QJk2e1xPlzx8PBV2mg23lA0gOlQ930OVdvAO', 'Ismael', 'Otero', '1995-12-12', 1, 0);

INSERT INTO usuarios(username, password, nombre, apellido, fecha_nacimiento, enabled, red_social)
VALUES('theprog', '$2a$12$zmkfvNAVLgYPcfnX8QJk2e1xPlzx8PBV2mg23lA0gOlQ930OVdvAO', 'Andrés', 'Serna', '1995-12-12', 1, 0);

-- asignacion de roles a usuarios 
INSERT INTO roles_usuarios(usuarios_id, roles_id)
VALUES(1, 1);

INSERT INTO roles_usuarios(usuarios_id, roles_id)
VALUES(1, 2);

INSERT INTO roles_usuarios(usuarios_id, roles_id)
VALUES(2, 2);

-- tabla de delitos
INSERT INTO delitos(nombre, descripcion, usuarios_id)
VALUES('Robo', 'Robo de vehiculo', 1);

INSERT INTO delitos(nombre, descripcion, usuarios_id)
VALUES('Asalto', 'Asalto a casa', 1);