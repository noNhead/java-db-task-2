create schema if not exists internet_shop;
create table internet_shop.users
(
    id          serial       not null
        constraint username_pk
            primary key,
    username    varchar(255) not null,
    email       varchar(255) not null,
    create_time timestamp    not null,
    active      boolean      not null,
    role        varchar(45)  not null,
    phone       varchar(45)  not null
);

insert into internet_shop.users (username, email, create_time, active, role, phone) values ('username', 'email', current_timestamp, true, 'role', 'phone');