package org.example.entity;

import java.sql.Timestamp;

public class FlowerSupplyFromSupplier {
    private int id;
    private int flowerId;
    private int supplierId;
    private int number;
    private Timestamp deliveryTimestamp;

    public FlowerSupplyFromSupplier(int id, int flowerId, int supplierId, int number, Timestamp deliveryTimestamp) {
        this.id = id;
        this.flowerId = flowerId;
        this.supplierId = supplierId;
        this.number = number;
        this.deliveryTimestamp = deliveryTimestamp;
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

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Timestamp getDeliveryTimestamp() {
        return deliveryTimestamp;
    }

    public void setDeliveryTimestamp(Timestamp deliveryTimestamp) {
        this.deliveryTimestamp = deliveryTimestamp;
    }
}
