import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderManagementSystem oms = new OrderManagementSystem();

        // ---- TEST 1: Add orders ----
        oms.addOrder(1, "customer1", List.of("sofa", "table"), "PLACED");
        oms.addOrder(2, "customer1", List.of("chair"), "PLACED");
        oms.addOrder(3, "customer2", List.of("lamp"), "SHIPPED");
        System.out.println("TEST 1 PASSED: Orders added");

        // ---- TEST 2: Duplicate order ----
        oms.addOrder(1, "customer3", List.of("bed"), "PLACED"); // should be ignored
        System.out.println("TEST 2: Order 1 customer should still be customer1: "
                + oms.getOrdersByCustomer("customer1").get(0).getCustomerId());

        // ---- TEST 3: getOrdersByCustomer ----
        System.out.println("TEST 3: customer1 orders count should be 2: "
                + oms.getOrdersByCustomer("customer1").size());

        // ---- TEST 4: getOrdersByCustomer non existent ----
        System.out.println("TEST 4: unknown customer should return empty list: "
                + oms.getOrdersByCustomer("unknown").size());

        // ---- TEST 5: getOrdersByStatus ----
        System.out.println("TEST 5: PLACED orders should be 2: "
                + oms.getOrdersByStatus("PLACED").size());

        // ---- TEST 6: updateStatus success ----
        boolean updated = oms.updateStatus(1, "PROCESSING");
        System.out.println("TEST 6: updateStatus should return true: " + updated);
        System.out.println("TEST 6: order 1 status should be PROCESSING: "
                + oms.getOrdersByStatus("PROCESSING").size());

        // ---- TEST 7: updateStatus non existent order ----
        boolean updatedFail = oms.updateStatus(99, "SHIPPED");
        System.out.println("TEST 7: updateStatus non existent should return false: " + updatedFail);

        // ---- TEST 8: PLACED count after update ----
        System.out.println("TEST 8: PLACED orders should now be 1: "
                + oms.getOrdersByStatus("PLACED").size());

        // ---- TEST 9: cancelOrder success ----
        boolean cancelled = oms.cancelOrder(2); // status is PLACED
        System.out.println("TEST 9: cancelOrder should return true: " + cancelled);
        System.out.println("TEST 9: CANCELLED orders should be 1: "
                + oms.getOrdersByStatus("CANCELLED").size());

        // ---- TEST 10: cancelOrder already SHIPPED ----
        boolean cancelFail = oms.cancelOrder(3); // status is SHIPPED
        System.out.println("TEST 10: cancelOrder SHIPPED should return false: " + cancelFail);

        // ---- TEST 11: cancelOrder non existent ----
        boolean cancelNotFound = oms.cancelOrder(99);
        System.out.println("TEST 11: cancelOrder non existent should return false: " + cancelNotFound);

        // ---- TEST 12: getMostRecentOrder ----
        Order recent = oms.getMostRecentOrder("customer1");
        System.out.println("TEST 12: most recent order for customer1 should be order 2: "
                + recent.getOrderId());

        // ---- TEST 13: getMostRecentOrder non existent customer ----
        Order noOrder = oms.getMostRecentOrder("unknown");
        System.out.println("TEST 13: getMostRecentOrder unknown should return null: " + noOrder);
    }
}
