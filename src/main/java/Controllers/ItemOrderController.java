package Controllers;

import Models.ItemOrder;
import Services.ItemOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/itemOrders/")
@RequiredArgsConstructor
public class ItemOrderController {

    private final ItemOrderService itemOrderService;

    public ItemOrderController() {
        this.itemOrderService = new ItemOrderService();
    }

    public void createItemOrder(ItemOrder itemOrder) {
        itemOrderService.addItemOrder(itemOrder);
        System.out.println("ItemOrder created with ID " + itemOrder.getId());
    }

    @GetMapping
    public List<ItemOrder> getAllItemOrders() {
        return itemOrderService.getAllItemOrders();
    }

    @GetMapping("{id}")
    public ItemOrder getItemOrderById(int id) {
        ItemOrder itemOrder = itemOrderService.getItemOrderById(id);
        if (itemOrder != null) {
            System.out.println("ItemOrder found with ID " + id);
        } else {
            System.out.println("ItemOrder not found with ID " + id);
        }
        return itemOrder;
    }

    @PutMapping
    public void updateItemOrder(ItemOrder itemOrder) {
        itemOrderService.updateItemOrder(itemOrder);
        System.out.println("ItemOrder with ID " + itemOrder.getId() + " has been updated.");
    }

    @DeleteMapping("{id}")
    public void deleteItemOrder(int id) {
        itemOrderService.deleteItemOrder(id);
        System.out.println("ItemOrder with ID " + id + " has been deleted.");
    }

    @GetMapping("/orderId/{id}")
    public List<ItemOrder> getItemOrdersByOrderId(int orderId) {
        List<ItemOrder> itemOrders = itemOrderService.getItemOrdersByOrderId(orderId);
        if (!itemOrders.isEmpty()) {
            System.out.println("ItemOrders found for Order ID " + orderId);
        } else {
            System.out.println("No ItemOrders found for Order ID " + orderId);
        }
        return itemOrders;
    }
}
