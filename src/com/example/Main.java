//��������, ������� �������
package com.example;

public class Main {
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();
        OrderManagerInvoker invoker = new OrderManagerInvoker();

        // ������� ������
        Order order1 = new Order(1, 5);
        order1.addItem("Pizza");
        order1.addItem("Coke");

        Order order2 = new Order(2, 3);
        order2.addItem("Burger");
        order2.addItem("Fries");

        // ��������� ������
        Command addOrderCommand1 = new AddOrderCommand(orderManager, order1);
        Command addOrderCommand2 = new AddOrderCommand(orderManager, order2);

        invoker.executeCommand(addOrderCommand1);
        invoker.executeCommand(addOrderCommand2);

        // ����������� �����
        Command editOrderCommand = new EditOrderCommand(orderManager, 1, "Coke", "Pepsi");
        invoker.executeCommand(editOrderCommand);

        // �������� �����
        Command deleteOrderCommand = new DeleteOrderCommand(orderManager, 2);
        invoker.executeCommand(deleteOrderCommand);

        // �������� ��� ������
        System.out.println("������� ������:");
        orderManager.printAllOrders();

        // �������� ��������� ��������
        System.out.println("\n�������� ��������� ��������.");
        invoker.undoLastCommand(); // ������ �������� ������

        // �������� ��� ������ ����� ������
        System.out.println("\n������� ������ ����� ������:");
        orderManager.printAllOrders();
    }
}
