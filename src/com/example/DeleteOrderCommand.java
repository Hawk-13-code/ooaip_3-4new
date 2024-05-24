package com.example;

public class DeleteOrderCommand implements Command {
    private OrderManager orderManager;
    private int orderId;
    private Order deletedOrder;

    public DeleteOrderCommand(OrderManager orderManager, int orderId) {
        this.orderManager = orderManager;
        this.orderId = orderId;
    }

    @Override
    public void execute() {
        deletedOrder = orderManager.getOrder(orderId);
        orderManager.removeOrder(orderId);
    }

    @Override
    public void undo() {
        orderManager.addOrder(deletedOrder);
    }
}