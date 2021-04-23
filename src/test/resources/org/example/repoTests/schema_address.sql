create schema if not exists internet_shop;

create table if not exists internet_shop.address
(
    id        serial       not null
        constraint address_pk
            primary key,
    country   varchar(255) not null,
    city      varchar(255) not null,
    street    varchar(255) not null,
    house     varchar(255),
    apartment varchar(255) not null
);

insert into internet_shop.address (country, city, street, house, apartment) values ('country', 'city', 'street', 'house', 'apartment');