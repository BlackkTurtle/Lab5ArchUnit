package Repositories;

import Models.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderRepository {

    private final List<Order> orders=new ArrayList<Order>();

    private void AddEntities(){
        orders.add(new Order(1,new Date(),"customer1","address1","phone1","email1","desciption1"));
        orders.add(new Order(2,new Date(),"customer2","address2","phone2","email2","desciption2"));
        orders.add(new Order(3,new Date(),"customer3","address3","phone3","email3","desciption3"));
    }

    public OrderRepository() {
        AddEntities();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Order getOrderById(int id) {
        return orders.stream()
                .filter(order -> order.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void AddOrder(Order order) {
        orders.add(order);
    }

    public void UpdateOrder(Order updatedOrder) {
        for (int i = 0; i < orders.size(); i++) {
            Order existingOrder = orders.get(i);
            if (existingOrder.getId() == updatedOrder.getId()) {
                // Update fields
                existingOrder.setDate(updatedOrder.getDate());
                existingOrder.setName(updatedOrder.getName());
                existingOrder.setAddress(updatedOrder.getAddress());
                existingOrder.setPhone(updatedOrder.getPhone());
                existingOrder.setEmail(updatedOrder.getEmail());
                existingOrder.setDescription(updatedOrder.getDescription());
                return;
            }
        }
    }

    public void DeleteOrder(int id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == id) {
                orders.remove(i);
                return;
            }
        }
    }

}
