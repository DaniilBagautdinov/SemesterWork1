CREATE TABLE homeworks
(
    id      serial primary key,
    user_id int references users (id),
    title   varchar(30),
    article varchar(1024)
);