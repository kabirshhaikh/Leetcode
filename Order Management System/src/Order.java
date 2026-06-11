import java.util.List;

public class Order {
    int orderId;
    String customerId;
    List<String> items;
    String status;

    public Order(int orderId, String customerId, List<String> items, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.items = items;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
