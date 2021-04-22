package org.example.repository;

import org.example.entity.*;
import org.example.repository.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ImitationOfWork {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImitationOfWork.class);
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private BouquetRepo bouquetRepo;
    @Autowired
    private CourierRepo courierRepo;
    @Autowired
    private FlowerRepo flowerRepo;
    @Autowired
    private FlowerInBouquetRepo flowerInBouquetRepo;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PromotionalCodeRepo promotionalCodeRepo;
    @Autowired
    private SupplierRepo supplierRepo;
    @Autowired
    private SupplyFlowerFromSupplierRepo supplyFlowerFromSupplierRepo;
    @Autowired
    private OrderRepo orderRepo;

    public void run(){
        /*Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        addressRepo.create(new Address(1, "country","city", "street", "house", "apartment1"));
        bouquetRepo.create(new Bouquet(1, "bouquet name", "description"));
        courierRepo.create(new Courier(1, "Name", "phone"));
        flowerRepo.create(new Flower(1,"name", 10));
        flowerInBouquetRepo.create(new FlowerInBouquet(1, 1, 1, 11));
        userRepository.create(new User(1, "username", "email", "phone", "role", true, timestamp));
        supplierRepo.create(new Supplier(1,"name","phone","email", 1));
        supplyFlowerFromSupplierRepo.create(new FlowerSupplyFromSupplier(1, 1, 2, 11, timestamp));
        promotionalCodeRepo.create(new PromotionalCode(1, "code", "description", true));
        orderRepo.create(new Order(1, 1, 1, 1, 1, 1, timestamp));*/


        //LOGGER.info(addressRepo.select(1).toString());
        //addressRepo.update(new Address(1, "country","city", "street", "house", "apartment2"));
        //LOGGER.info(addressRepo.select(1).toString());
    }
}
