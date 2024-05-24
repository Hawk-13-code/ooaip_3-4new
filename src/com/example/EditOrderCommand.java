package com.example;

public class EditOrderCommand implements Command {
    private OrderManager orderManager;
    private int orderId;
    private String oldItem;
    private String newItem;

    public EditOrderCommand(OrderManager orderManager, int orderId, String oldItem, String newItem) {
        this.orderManager = orderManager;
        this.orderId = orderId;
        this.oldItem = oldItem;
        this.newItem = newItem;
    }

    @Override
    public void execute() {
        orderManager.editOrder(orderId, oldItem, newItem);
    }

    @Override
    public void undo() {
        orderManager.editOrder(orderId, newItem, oldItem);
    }
}
