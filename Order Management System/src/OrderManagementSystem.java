import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class OrderManagementSystem {
    HashMap<Integer, Order> orderMap;
    HashMap<String, List<Order>> customerMap;
    HashMap<String, List<Order>> statusMap;

    public OrderManagementSystem() {
        orderMap = new HashMap<>();
        customerMap = new HashMap<>();
        statusMap = new HashMap<>();
    }


    // Add a new order to the system
    // orderId is unique
    void addOrder(int orderId, String customerId, List<String> items, String status) {
        //we create a new entry only if the key does not exists:
        if (!orderMap.containsKey(orderId)) {
            Order newOrder = new Order(orderId, customerId, items, status);
            orderMap.put(orderId, newOrder);

            //then i add this order to the customerMap:
            List<Order> tempCustomerMapList = customerMap.getOrDefault(customerId, new ArrayList<>());
            tempCustomerMapList.add(newOrder);
            customerMap.put(customerId, tempCustomerMapList);

            //then i update the status map:
            List<Order> tempStatusMapList = statusMap.getOrDefault(status, new ArrayList<>());
            tempStatusMapList.add(newOrder);
            statusMap.put(status, tempStatusMapList);
        }
    }

    // Update the status of an existing order
    // Possible statuses: PLACED, PROCESSING, SHIPPED,
    //                    DELIVERED, CANCELLED
    // Return false if orderId doesn't exist
    boolean updateStatus(int orderId, String newStatus) {
        if (newStatus == null || orderId < 1) {
            return false;
        }

        if (!orderMap.containsKey(orderId)) {
            return false;
        }

        Order order = orderMap.get(orderId);

        //grab old status:
        String oldStatus = order.getStatus();

        //set new status:
        order.setStatus(newStatus);

        //customerMap does not need update because it point to the same object, it gets update automatically when we update the order object

        //the status needs update because we are the key is status, even though the Object is updated automatically the status is not:
        List<Order> statusOrderList = statusMap.getOrDefault(oldStatus, new ArrayList<>());
        if (statusOrderList == null || statusOrderList.size() == 0) {
            return false;
        }

        //remove the order from the list:
        statusOrderList.remove(order);

        //add the updated order in new order status:
        List<Order> newStatusList = statusMap.getOrDefault(newStatus, new ArrayList<>());
        newStatusList.add(order);
        statusMap.put(newStatus, newStatusList);

        return true;
    }

    // Get all orders for a specific customer
    // Return empty list if customer has no orders
    List<Order> getOrdersByCustomer(String customerId) {
        List<Order> allOrderForACustomer = customerMap.getOrDefault(customerId, new ArrayList<>());
        return allOrderForACustomer;
    }

    // Get all orders with a specific status
    // Return empty list if none found
    List<Order> getOrdersByStatus(String status) {
        List<Order> allOrderByAStatus = statusMap.getOrDefault(status, new ArrayList<>());
        return allOrderByAStatus;
    }

    // Cancel an order
    // Can only cancel if status is PLACED or PROCESSING
    // Return false if cannot cancel
    boolean cancelOrder(int orderId) {
        if (orderId < 1) {
            return false;
        }

        Order order = orderMap.get(orderId);
        if (order == null) {
            return false;
        }

        if (!order.getStatus().equals("PLACED") && !order.getStatus().equals("PROCESSING")) {
            return false;
        }

        return this.updateStatus(orderId, "CANCELLED");
    }

    // Get most recent order for a customer
    // Return null if customer has no orders
    Order getMostRecentOrder(String customerId) {
        if (customerId == null) {
            return null;
        }

        List<Order> orderList = customerMap.getOrDefault(customerId, new ArrayList<>());
        if (orderList == null || orderList.size() == 0) {
            return null;
        }

        orderList.sort((a, b) -> b.getOrderId() - a.getOrderId());

        return orderList.get(0);
    }
}
