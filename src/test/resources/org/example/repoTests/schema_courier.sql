create schema if not exists internet_shop;
create table internet_shop.courier
(
    id    serial       not null
        constraint courier_pk
            primary key,
    name  varchar(255) not null,
    phone varchar(255) not null
);

insert into internet_shop.courier (name, phone) values ('name', 'phone');