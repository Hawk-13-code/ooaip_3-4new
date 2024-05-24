package com.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class OrderCommandTest {
    private OrderManager orderManager;
    private Order order1;
    private Order order2;

    @Before
    public void setUp() {
        orderManager = new OrderManager();

        order1 = new Order(1, 5);
        order1.addItem("Pizza");
        order1.addItem("Coke");

        order2 = new Order(2, 3);
        order2.addItem("Burger");
        order2.addItem("Fries");

        orderManager.addOrder(order1);
        orderManager.addOrder(order2);
    }

    @Test
    public void testAddOrderCommand() {
        Order newOrder = new Order(3, 7);
        newOrder.addItem("Salad");
        AddOrderCommand addOrderCommand = new AddOrderCommand(orderManager, newOrder);

        addOrderCommand.execute();
        assertEquals(newOrder, orderManager.getOrder(3));

        addOrderCommand.undo();
        assertNull(orderManager.getOrder(3));
    }

    @Test
    public void testEditOrderCommand() {
        EditOrderCommand editOrderCommand = new EditOrderCommand(orderManager, 1, "Coke", "Pepsi");

        editOrderCommand.execute();
        assertTrue(orderManager.getOrder(1).getItems().contains("Pepsi"));

        editOrderCommand.undo();
        assertFalse(orderManager.getOrder(1).getItems().contains("Pepsi"));
    }

    @Test
    public void testDeleteOrderCommand() {
        DeleteOrderCommand deleteOrderCommand = new DeleteOrderCommand(orderManager, 2);

        deleteOrderCommand.execute();
        assertNull(orderManager.getOrder(2));

        deleteOrderCommand.undo();
        assertEquals(order2, orderManager.getOrder(2));
    }
}
