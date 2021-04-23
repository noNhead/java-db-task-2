create schema if not exists internet_shop;
create table internet_shop.bouquet
(
    id          serial       not null
        constraint bouquet_pk
            primary key,
    name        varchar(255) not null,
    description varchar(255) not null
);

insert into internet_shop.bouquet (name, description) values ('name', 'description');