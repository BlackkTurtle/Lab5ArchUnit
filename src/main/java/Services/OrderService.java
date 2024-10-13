package Services;

import Models.Order;
import Repositories.OrderRepository;

import java.util.List;

public class OrderService {
    private OrderRepository orderRepository;

    public OrderService() {
        this.orderRepository = new OrderRepository();
    }

    public void addOrder(Order order) {
        orderRepository.AddOrder(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.getOrders();
    }

    public Order getOrderById(int id) {
        return orderRepository.getOrderById(id);
    }

    public void updateOrder(Order updatedOrder) {
        orderRepository.UpdateOrder(updatedOrder);
    }

    public void deleteOrder(int id) {
        orderRepository.DeleteOrder(id);
    }
}
