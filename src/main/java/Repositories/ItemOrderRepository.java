package Repositories;


import Models.ItemOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemOrderRepository {

    private final List<ItemOrder> itemOrders = new ArrayList<>();

    private void AddEntities() {
        itemOrders.add(new ItemOrder(1, "Item1", "Description1", 10, 1));
        itemOrders.add(new ItemOrder(2, "Item2", "Description2", 20, 1));
        itemOrders.add(new ItemOrder(3, "Item3", "Description3", 15, 2));
    }

    public ItemOrderRepository() {
        AddEntities();
    }

    public void addItemOrder(ItemOrder itemOrder) {
        itemOrders.add(itemOrder);
        System.out.println("ItemOrder added with ID " + itemOrder.getId());
    }

    public List<ItemOrder> getItemOrders() {
        return itemOrders;
    }

    public ItemOrder getItemOrderById(int id) {
        return itemOrders.stream()
                .filter(itemOrder -> itemOrder.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateItemOrder(ItemOrder updatedItemOrder) {
        Optional<ItemOrder> existingOrderOpt = itemOrders.stream()
                .filter(itemOrder -> itemOrder.getId() == updatedItemOrder.getId())
                .findFirst();

        if (existingOrderOpt.isPresent()) {
            ItemOrder existingOrder = existingOrderOpt.get();
            existingOrder.setItemName(updatedItemOrder.getItemName());
            existingOrder.setDescription(updatedItemOrder.getDescription());
            existingOrder.setQuantity(updatedItemOrder.getQuantity());
            existingOrder.setOrderId(updatedItemOrder.getOrderId());
        }
    }

    public void deleteItemOrder(int id) {
        boolean removed = itemOrders.removeIf(itemOrder -> itemOrder.getId() == id);
        if (removed) {
            System.out.println("ItemOrder with ID " + id + " has been deleted.");
        }
    }
}
