CREATE TABLE lessons
(
    id          serial primary key,
    title       varchar(200),
    description varchar(200),
    article     varchar(1024),
    link        varchar(200),
    photo_title varchar(50)
);