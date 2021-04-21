package org.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Configurable
public class CreateForNewDb {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void createNewSchemaAndTable(){
        jdbcTemplate.execute("CREATE SCHEMA internet_shop");
        jdbcTemplate.execute("create table internet_shop.address (" +
                "id serial not null constraint address_pk primary key, " +
                "country varchar(255) not null, " +
                "city varchar(255) not null, " +
                "street varchar(255) not null, " +
                "house varchar(255), " +
                "apartment varchar(255) not null)");
        jdbcTemplate.execute("create table internet_shop.bouquet(" +
                "id serial not null constraint bouquet_pk primary key, " +
                "name varchar(255) not null, " +
                "description varchar(255) not null)");
        jdbcTemplate.execute("create table internet_shop.courier (" +
                "id serial not null constraint courier_pk primary key, " +
                "name  varchar(255) not null, " +
                "phone varchar(255) not null )");
        jdbcTemplate.execute("create table internet_shop.flower(" +
                "id serial not null constraint flower_pk primary key, " +
                "name varchar(255) not null, " +
                "number integer not null)");
        jdbcTemplate.execute("create table internet_shop.flower_has_bouquet (" +
                "id serial not null constraint flower_has_bouquet_pk primary key, " +
                "flower_id integer not null constraint flower_has_bouquet_flower_id_fk " +
                "references flower on update restrict, " +
                "bouquet_id integer not null constraint flower_has_bouquet_bouquet_id_fk " +
                "references bouquet on update restrict, " +
                "number integer not null)");
        jdbcTemplate.execute("create table internet_shop.supplier (" +
                "id serial not null constraint supplier_pk primary key," +
                "name varchar(255) not null," +
                "phone varchar(255), " +
                "email varchar(255) not null, " +
                "address_id integer not null constraint supplier_address_id_fk " +
                "references address on update restrict)");
        jdbcTemplate.execute("create table internet_shop.flower_has_supplier(" +
                "    id            serial  not null constraint flower_has_supplier_pk primary key," +
                "    flower_id     integer not null constraint flower_has_supplier_flower_id_fk references flower on update restrict," +
                "    supplier_id   integer not null constraint flower_has_supplier_supplier_id_fk references supplier on update restrict," +
                "    number        integer not null," +
                "    delivery_date timestamp" +
                ");");
        jdbcTemplate.execute("create table internet_shop.users(" +
                "    id          serial       not null constraint username_pk primary key," +
                "    username    varchar(255) not null," +
                "    email       varchar(255) not null," +
                "    create_time timestamp    not null," +
                "    active      boolean      not null," +
                "    role        varchar(45)  not null," +
                "    phone       varchar(45)  not null" +
                ");");
        jdbcTemplate.execute("create table internet_shop.promotional_code( " +
                "id serial not null constraint promotional_code_pk primary key, " +
                "code varchar(255) not null, " +
                "description varchar(255) not null, " +
                "active boolean default false not null" +
                ");");
        jdbcTemplate.execute("create table internet_shop.order( " +
                "id serial not null constraint order_pk primary key, " +
                "username_id integer not null constraint order_username_id_fk " +
                "references users on update restrict, " +
                "date timestamp not null, " +
                "courier_id integer not null constraint order_courier_id_fk " +
                "references courier on update restrict, " +
                "promotional_codes integer not null constraint order_promotional_code_id_fk " +
                "references promotional_code on update restrict, " +
                "bouquet_id integer not null constraint order_bouquet_id_fk " +
                "references bouquet on update restrict, " +
                "address_id integer not null constraint order_address_id_fk " +
                "references address on update restrict" +
                ");");
    }
}
