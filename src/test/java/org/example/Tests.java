package org.example;

import org.example.repoTests.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.test.context.jdbc.Sql;

@JdbcTest
@Sql({"schema.sql", "test-data.sql"})
public class Tests {
    private final AddressTest addressTest = new AddressTest();
    private final BouquetTest bouquetTest = new BouquetTest();
    private final CourierTest courierTest = new CourierTest();
    private final FlowerTest flowerTest = new FlowerTest();
    private final FlowerInBouquetTest flowerInBouquetTest = new FlowerInBouquetTest();
    private final FlowerFromSupplierTest flowerFromSupplierTest = new FlowerFromSupplierTest();
    private final OrderRepoTest orderRepoTest = new OrderRepoTest();
    private final PromotionalCodeTest promotionalCodeTest = new PromotionalCodeTest();
    private final SupplierTest supplierTest = new SupplierTest();
    private final UsersTest usersTest = new UsersTest();

    @Test
    public void dbTests(){
        //Address tests
        addressTest.create();
        addressTest.select();
        addressTest.update();
        //Bouquet tests
        bouquetTest.create();
        bouquetTest.select();
        bouquetTest.update();
        //Courier tests
        courierTest.create();
        courierTest.select();
        courierTest.update();
        //Flower tests
        flowerTest.create();
        flowerTest.select();
        flowerTest.update();
        //FlowerInBouquet tests
        flowerInBouquetTest.create();
        flowerInBouquetTest.select();
        flowerInBouquetTest.update();
        //FlowerFromSupplier
        flowerFromSupplierTest.create();
        flowerFromSupplierTest.select();
        flowerFromSupplierTest.update();
        //Order
        orderRepoTest.create();
        orderRepoTest.select();
        orderRepoTest.update();
        //PromotionalCode
        promotionalCodeTest.create();
        promotionalCodeTest.select();
        promotionalCodeTest.update();
        //Supplier
        supplierTest.create();
        supplierTest.select();
        supplierTest.update();
        //Users
        usersTest.create();
        usersTest.select();
        usersTest.update();

        //Delete all first row
        addressTest.delete();
        bouquetTest.delete();
        courierTest.delete();
        flowerTest.delete();
        flowerInBouquetTest.delete();
        flowerFromSupplierTest.delete();
        orderRepoTest.delete();
        promotionalCodeTest.delete();
        supplierTest.delete();
        usersTest.delete();
    }
}
