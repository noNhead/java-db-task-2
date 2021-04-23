create schema if not exists internet_shop;
create table internet_shop.flower_has_supplier
(
    id            serial  not null
        constraint flower_has_supplier_pk
            primary key,
    flower_id     integer not null,
    supplier_id   integer not null,
    number        integer not null,
    delivery_date timestamp
);

insert into internet_shop.flower_has_supplier (flower_id, supplier_id, number, delivery_date) values (1, 1, 10, current_timestamp);