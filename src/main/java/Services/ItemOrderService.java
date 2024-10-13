package Services;

import Models.ItemOrder;
import Repositories.ItemOrderRepository;

import java.util.List;

public class ItemOrderService {
    private final ItemOrderRepository itemOrderRepository;

    public ItemOrderService() {
        this.itemOrderRepository = new ItemOrderRepository();
    }

    public void addItemOrder(ItemOrder itemOrder) {
        itemOrderRepository.addItemOrder(itemOrder);
    }

    public List<ItemOrder> getAllItemOrders() {
        return itemOrderRepository.getItemOrders();
    }

    public ItemOrder getItemOrderById(int id) {
        return itemOrderRepository.getItemOrderById(id);
    }

    public void updateItemOrder(ItemOrder updatedItemOrder) {
        itemOrderRepository.updateItemOrder(updatedItemOrder);
    }

    public void deleteItemOrder(int id) {
        itemOrderRepository.deleteItemOrder(id);
    }

    public List<ItemOrder> getItemOrdersByOrderId(int orderId) {
        return itemOrderRepository.getItemOrders()
                .stream()
                .filter(itemOrder -> itemOrder.getOrderId() == orderId)
                .toList();
    }
}
