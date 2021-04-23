create schema internet_shop;

create table internet_shop.address
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

create table internet_shop.bouquet
(
    id          serial       not null
        constraint bouquet_pk
            primary key,
    name        varchar(255) not null,
    description varchar(255) not null
);

create table internet_shop.courier
(
    id    serial       not null
        constraint courier_pk
            primary key,
    name  varchar(255) not null,
    phone varchar(255) not null
);

create table internet_shop.flower
(
    id     serial       not null
        constraint flower_pk
            primary key,
    name   varchar(255) not null,
    number integer      not null
);

create table internet_shop.flower_has_bouquet
(
    id         serial  not null
        constraint flower_has_bouquet_pk
            primary key,
    flower_id  integer not null,
    bouquet_id integer not null,
    number     integer not null
);

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

create table internet_shop.promotional_code
(
    id          serial                not null
        constraint promotional_code_pk
            primary key,
    code        varchar(255)          not null,
    description varchar(255)          not null,
    active      boolean default false not null
);

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

alter table internet_shop.flower_has_bouquet
    add constraint flower_has_bouquet_flower_id_fk
        foreign key (flower_id) references flower
            on update restrict;

alter table internet_shop.flower_has_bouquet
    add constraint flower_has_bouquet_bouquet_id_fk
        foreign key (bouquet_id) references bouquet
            on update restrict;

alter table internet_shop.flower_has_supplier
    add constraint flower_has_supplier_flower_id_fk
        foreign key (flower_id) references flower
            on update restrict;

alter table internet_shop.flower_has_supplier
    add constraint flower_has_supplier_supplier_id_fk
        foreign key (supplier_id) references supplier
            on update restrict;

alter table internet_shop.order_repo
    add constraint order_users_id_fk
        foreign key (username_id) references users
            on update restrict;

alter table internet_shop.order_repo
    add constraint order_courier_id_fk
        foreign key (courier_id) references courier
            on update restrict;

alter table internet_shop.order_repo
    add constraint order_promotional_codes_fk
        foreign key (promotional_codes) references promotional_code
            on update restrict;

alter table internet_shop.order_repo
    add constraint order_bouquet_id_fk
        foreign key (bouquet_id) references bouquet
            on update restrict;

alter table internet_shop.order_repo
    add constraint order_address_id_fk
        foreign key (address_id) references address
            on update restrict;

alter table internet_shop.supplier
    add constraint supplier_address_id_fk
        foreign key (address_id) references address
            on update restrict;