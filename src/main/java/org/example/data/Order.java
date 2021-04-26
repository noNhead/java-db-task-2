package org.example.data;

import java.sql.Timestamp;

public class Order {
    private int id;
    private int usernameId;
    private int courierId;
    private int promotionalCodeId;
    private int bouquetId;
    private int addressId;
    private Timestamp timeToDelivery;

    public Order(int id, int usernameId, int courierId, int promotionalCodeId, int bouquetId, int addressId, Timestamp timeToDelivery) {
        this.id = id;
        this.usernameId = usernameId;
        this.courierId = courierId;
        this.promotionalCodeId = promotionalCodeId;
        this.bouquetId = bouquetId;
        this.addressId = addressId;
        this.timeToDelivery = timeToDelivery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsernameId() {
        return usernameId;
    }

    public void setUsernameId(int usernameId) {
        this.usernameId = usernameId;
    }

    public int getCourierId() {
        return courierId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }

    public int getPromotionalCodeId() {
        return promotionalCodeId;
    }

    public void setPromotionalCodeId(int promotionalCodeId) {
        this.promotionalCodeId = promotionalCodeId;
    }

    public int getBouquetId() {
        return bouquetId;
    }

    public void setBouquetId(int bouquetId) {
        this.bouquetId = bouquetId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public Timestamp getTimeToDelivery() {
        return timeToDelivery;
    }

    public void setTimeToDelivery(Timestamp timeToDelivery) {
        this.timeToDelivery = timeToDelivery;
    }
}
