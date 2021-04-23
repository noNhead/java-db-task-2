create schema if not exists internet_shop;
create table internet_shop.supplier
(
    id         serial       not null
        constraint supplier_pk
            primary key,
    name       varchar(255) not null,
    phone      varchar(255),
    email      varchar(255) not null,
    address_id integer      not null
);

insert into internet_shop.supplier (name, phone, email, address_id) values ('name', 'phone', 'email', 1);