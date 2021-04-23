create schema if not exists internet_shop;
create table internet_shop.order_repo
(
    id                serial    not null
        constraint order_pk
            primary key,
    username_id       integer   not null,
    date              timestamp not null,
    courier_id        integer   not null,
    promotional_codes integer   not null,
    bouquet_id        integer   not null,
    address_id        integer   not null
);

insert into internet_shop.order_repo (username_id, date, courier_id, promotional_codes, bouquet_id, address_id) values (1, current_timestamp, 1, 1, 1, 1);