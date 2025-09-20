DROP TABLE USUARIOS;

CREATE TABLE USUARIOS(
id bigint primary key,
login varchar(255) not null unique,
password varchar(255) not null,
role smallint not null
);