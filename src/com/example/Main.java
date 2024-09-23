//ресторан, паттерн команда
package com.example;

public class Main {
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();
        OrderManagerInvoker invoker = new OrderManagerInvoker();

        // Создаем заказы
        Order order1 = new Order(1, 5);
        order1.addItem("Pizza");
        order1.addItem("Coke");

        Order order2 = new Order(2, 3);
        order2.addItem("Burger");
        order2.addItem("Fries");

        // Добавляем заказы
        Command addOrderCommand1 = new AddOrderCommand(orderManager, order1);
        Command addOrderCommand2 = new AddOrderCommand(orderManager, order2);

        invoker.executeCommand(addOrderCommand1);
        invoker.executeCommand(addOrderCommand2);

        // Редактируем заказ
        Command editOrderCommand = new EditOrderCommand(orderManager, 1, "Coke", "Pepsi");
        invoker.executeCommand(editOrderCommand);

        // Отменяем заказ
        Command deleteOrderCommand = new DeleteOrderCommand(orderManager, 2);
        invoker.executeCommand(deleteOrderCommand);

        // Печатаем все заказы
        System.out.println("Текущие заказы:");
        orderManager.printAllOrders();

        // Отменяем последние действия
        System.out.println("\nОтменяем последние действия.");
        invoker.undoLastCommand(); // Отмена удаления заказа

        // Печатаем все заказы после отмены
        System.out.println("\nТекущие заказы после отмены:");
        orderManager.printAllOrders();
    }
}
