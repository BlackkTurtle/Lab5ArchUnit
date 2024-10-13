package Models;

public class ItemOrder {
    private int id;
    private String itemName;
    private String description;
    private int quantity;
    private int OrderId;

    public ItemOrder(int id, String itemName, String description, int quantity, int orderId)
    {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.quantity = quantity;
        OrderId = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }
}
