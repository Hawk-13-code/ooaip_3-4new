package com.example;

import java.util.HashMap;
import java.util.Map;

public class OrderManager {
    private Map<Integer, Order> orders = new HashMap<>();

    public void addOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    public void removeOrder(int orderId) {
        orders.remove(orderId);
    }

    public Order getOrder(int orderId) {
        return orders.get(orderId);
    }

    public void editOrder(int orderId, String oldItem, String newItem) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.removeItem(oldItem);
            order.addItem(newItem);
        }
    }

    public void printAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("��� ������� �������.");
        } else {
            for (Order order : orders.values()) {
                System.out.println("����� ID: " + order.getOrderId() + ", ����: " + order.getTableNumber() + ", ������: " + order.getItems());
            }
        }
    }
}
