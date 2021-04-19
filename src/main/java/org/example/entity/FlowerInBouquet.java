package org.example.entity;

public class FlowerInBouquet {
    private int id;
    private int flowerId;
    private int bouquetId;
    private int number;

    public FlowerInBouquet(int id, int flowerId, int bouquetId, int number) {
        this.id = id;
        this.flowerId = flowerId;
        this.bouquetId = bouquetId;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(int flowerId) {
        this.flowerId = flowerId;
    }

    public int getBouquetId() {
        return bouquetId;
    }

    public void setBouquetId(int bouquetId) {
        this.bouquetId = bouquetId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
