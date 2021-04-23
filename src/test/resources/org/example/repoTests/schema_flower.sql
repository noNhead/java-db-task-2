create schema if not exists internet_shop;
create table internet_shop.flower
(
    id     serial       not null
        constraint flower_pk
            primary key,
    name   varchar(255) not null,
    number integer      not null
);

insert into internet_shop.flower (name, number) values ('name', 10);