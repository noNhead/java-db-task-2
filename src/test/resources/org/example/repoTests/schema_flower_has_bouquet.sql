create schema if not exists internet_shop;
create table internet_shop.flower_has_bouquet
(
    id         serial  not null
        constraint flower_has_bouquet_pk
            primary key,
    flower_id  integer not null,
    bouquet_id integer not null,
    number     integer not null
);

insert into internet_shop.flower_has_bouquet (flower_id, bouquet_id, number) values (1, 1, 10);