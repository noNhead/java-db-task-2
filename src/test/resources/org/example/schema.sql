create schema INTERNET_SHOP;

create table INTERNET_SHOP.ADDRESS
(
    ID        serial       not null
        constraint ADDRESS_PK
            primary key,
    COUNTRY   varchar(255) not null,
    CITY      varchar(255) not null,
    STREET    varchar(255) not null,
    HOUSE     varchar(255),
    APARTMENT varchar(255) not null
);

create table INTERNET_SHOP.BOUQUET
(
    ID          serial       not null
        constraint BOUQUET_PK
            primary key,
    NAME        varchar(255) not null,
    DESCRIPTION varchar(255) not null
);

create table INTERNET_SHOP.COURIER
(
    ID    serial       not null
        constraint COURIER_PK
            primary key,
    NAME  varchar(255) not null,
    PHONE varchar(255) not null
);

create table INTERNET_SHOP.FLOWER
(
    ID     serial       not null
        constraint FLOWER_PK
            primary key,
    NAME   varchar(255) not null,
    NUMBER integer      not null
);

create table INTERNET_SHOP.FLOWER_HAS_BOUQUET
(
    ID         serial  not null
        constraint FLOWER_HAS_BOUQUET_PK
            primary key,
    FLOWER_ID  integer not null,
    BOUQUET_ID integer not null,
    NUMBER     integer not null
);

create table INTERNET_SHOP.FLOWER_HAS_SUPPLIER
(
    ID            serial  not null
        constraint FLOWER_HAS_SUPPLIER_PK
            primary key,
    FLOWER_ID     integer not null,
    SUPPLIER_ID   integer not null,
    NUMBER        integer not null,
    DELIVERY_DATE timestamp
);

create table INTERNET_SHOP."ORDER"
(
    ID                serial    not null
        constraint ORDER_PK
            primary key,
    USERNAME_ID       integer   not null,
    DATE              timestamp not null,
    COURIER_ID        integer   not null,
    PROMOTIONAL_CODES integer   not null,
    BOUQUET_ID        integer   not null,
    ADDRESS_ID        integer   not null
);

create table INTERNET_SHOP.PROMOTIONAL_CODE
(
    ID          serial                not null
        constraint PROMOTIONAL_CODE_PK
            primary key,
    CODE        varchar(255)          not null,
    DESCRIPTION varchar(255)          not null,
    ACTIVE      boolean default false not null
);

create table INTERNET_SHOP.SUPPLIER
(
    ID         serial       not null
        constraint SUPPLIER_PK
            primary key,
    NAME       varchar(255) not null,
    PHONE      varchar(255),
    EMAIL      varchar(255) not null,
    ADDRESS_ID integer      not null
);

create table INTERNET_SHOP.USERS
(
    ID          serial       not null
        constraint USERNAME_PK
            primary key,
    USERNAME    varchar(255) not null,
    EMAIL       varchar(255) not null,
    CREATE_TIME timestamp    not null,
    ACTIVE      boolean      not null,
    ROLE        varchar(45)  not null,
    PHONE       varchar(45)  not null
);

alter table INTERNET_SHOP.FLOWER_HAS_BOUQUET
    add constraint FLOWER_HAS_BOUQUET_FLOWER_ID_FK
        foreign key (FLOWER_ID) references FLOWER
            on update restrict;

alter table INTERNET_SHOP.FLOWER_HAS_BOUQUET
    add constraint FLOWER_HAS_BOUQUET_BOUQUET_ID_FK
        foreign key (BOUQUET_ID) references BOUQUET
            on update restrict;

alter table INTERNET_SHOP.FLOWER_HAS_SUPPLIER
    add constraint FLOWER_HAS_SUPPLIER_FLOWER_ID_FK
    foreign key (FLOWER_ID) references FLOWER
            on update restrict;

alter table INTERNET_SHOP.FLOWER_HAS_SUPPLIER
    add constraint FLOWER_HAS_SUPPLIER_SUPPLIER_ID_FK
        foreign key (SUPPLIER_ID) references SUPPLIER
            on update restrict;

alter table INTERNET_SHOP."ORDER"
    add constraint ORDER_USERS_ID_FK
        foreign key (USERNAME_ID) references USERS
            on update restrict;

alter table INTERNET_SHOP."ORDER"
    add constraint ORDER_COURIER_ID_FK
        foreign key (COURIER_ID) references COURIER
            on update restrict;

alter table INTERNET_SHOP."ORDER"
    add constraint ORDER_PROMOTIONAL_CODES_FK
        foreign key (PROMOTIONAL_CODES) references PROMOTIONAL_CODE
            on update restrict;

alter table INTERNET_SHOP."ORDER"
    add constraint ORDER_BOUQUET_ID_FK
        foreign key (BOUQUET_ID) references BOUQUET
            on update restrict;

alter table INTERNET_SHOP."ORDER"
    add constraint ORDER_ADDRESS_ID_FK
        foreign key (ADDRESS_ID) references ADDRESS
            on update restrict;

alter table INTERNET_SHOP.SUPPLIER
    add constraint SUPPLIER_ADDRESS_ID_FK
        foreign key (ADDRESS_ID) references ADDRESS
            on update restrict;