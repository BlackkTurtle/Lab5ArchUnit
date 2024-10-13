package Controllers;

import Models.Order;
import Services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders/")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    public OrderController() {
        this.orderService = new OrderService();
    }

    public void createOrder(Order order) {
        orderService.addOrder(order);
        System.out.println("Order created with ID " + order.getId());
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("{id}")
    public Order getOrderById(int id) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            System.out.println("Order found with ID " + id);
        } else {
            System.out.println("Order not found with ID " + id);
        }
        return order;
    }

    @PutMapping
    public void updateOrder(Order order) {
        orderService.updateOrder(order);
        System.out.println("Order with ID " + order.getId() + " has been updated.");
    }

    @DeleteMapping("{id}")
    public void deleteOrder(int id) {
        orderService.deleteOrder(id);
        System.out.println("Order with ID " + id + " has been deleted.");
    }
}
