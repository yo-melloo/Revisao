CREATE TABLE usuarios(
    id bigint primary key,
    username varchar(255) unique,
    email varchar(255) unique not null,
    senha varchar(255) not null
);