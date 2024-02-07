create table if not exists account(
    id int primary key auto_increment,
    email varchar(255) unique not null,
    name varchar(255),
    password varchar(255) not null
);