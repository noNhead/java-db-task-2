create schema if not exists internet_shop;
create table internet_shop.promotional_code
(
    id          serial                not null
        constraint promotional_code_pk
            primary key,
    code        varchar(255)          not null,
    description varchar(255)          not null,
    active      boolean default false not null
);

insert into internet_shop.promotional_code (code, description, active) values ('code', 'description', true);