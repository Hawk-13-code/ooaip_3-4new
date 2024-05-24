package com.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private int tableNumber;
    private List<String> items;

    public Order(int orderId, int tableNumber) {
        this.orderId = orderId;
        this.tableNumber = tableNumber;
        this.items = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public List<String> getItems() {
        return items;
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }
}
