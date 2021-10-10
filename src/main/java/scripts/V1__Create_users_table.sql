CREATE TABLE users
(
    id          serial primary key,
    first_name  varchar(30),
    second_name varchar(30),
    login       varchar(30),
    password    varchar(128)
);