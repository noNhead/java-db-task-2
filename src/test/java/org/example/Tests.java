package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Tests {
    AddressTest addressTest = new AddressTest();
    Connection connection;
    @BeforeEach
    public void setup(){
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:test");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void dbTests(){
        //Address tests
        addressTest.createAddress();
        addressTest.selectAddress();
        addressTest.updateAddress();
        addressTest.deleteAddress();
        //Bouquet tests

        //Courier tests

        //Flower tests

        //FlowerInBouquet tests
    }
}
