package com.example;

public class AddOrderCommand implements Command {
    private OrderManager orderManager;
    private Order order;

    public AddOrderCommand(OrderManager orderManager, Order order) {
        this.orderManager = orderManager;
        this.order = order;
    }

    @Override
    public void execute() {
        orderManager.addOrder(order);
    }

    @Override
    public void undo() {
        orderManager.removeOrder(order.getOrderId());
    }
}
