import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShipmentSystem {
    HashMap<String, List<Package>> senderMap;
    HashMap<String, List<Package>> statusMap;
    HashMap<Integer, Package> packageMap;
    HashMap<String, List<Package>> receiverMap;

    public ShipmentSystem() {
        this.senderMap = new HashMap<>();
        this.statusMap = new HashMap<>();
        this.packageMap = new HashMap<>();
        this.receiverMap = new HashMap<>();
    }

    // Add a new package
    // packageId is unique
    void addPackage(int packageId, String senderId, String receiverId, double weight, String status) {
        if (packageId < 1 || senderId == null || senderId.equals("") || receiverId == null || receiverId.equals("") || weight < 0 || status == null || status.equals("")) {
            return;
        }

        if (packageMap.containsKey(packageId)) {
            return;
        }

        //create package and put into packageMap:
        Package newPackage = new Package(packageId, senderId, receiverId, weight, status);
        packageMap.put(packageId, newPackage);

        //add package into sender map:
        List<Package> senderList = senderMap.getOrDefault(senderId, new ArrayList<>());
        senderList.add(newPackage);
        senderMap.put(senderId, senderList);

        //add package for the status map:
        List<Package> statusList = statusMap.getOrDefault(status, new ArrayList<>());
        statusList.add(newPackage);
        statusMap.put(status, statusList);

        //add package to the receiver map:
        List<Package> receiverList = receiverMap.getOrDefault(receiverId, new ArrayList<>());
        receiverList.add(newPackage);
        receiverMap.put(receiverId, receiverList);
    }

    // Update package status
    // Statuses: CREATED, IN_TRANSIT, OUT_FOR_DELIVERY,
    //           DELIVERED, FAILED
    // Return false if packageId doesn't exist
    boolean updateStatus(int packageId, String newStatus) {
        if (packageId < 1 || newStatus == null || newStatus == "") {
            return false;
        }

        Package updatedPackage = null;
        updatedPackage = packageMap.getOrDefault(packageId, null);

        if (updatedPackage == null) {
            return false;
        }

        //grab old status:
        String oldStatus = updatedPackage.getStatus();

        //this will set the status for all the objects in any map
        updatedPackage.setStatus(newStatus);

        //no need to update separately for sender map and receiverMap:

        //update status map:
        List<Package> statusList = statusMap.getOrDefault(oldStatus, new ArrayList<>());
        if (statusList == null || statusList.size() == 0) {
            return false;
        }

        //we dont need to keep updated package in old list because its status has changed:
        statusList.remove(updatedPackage);

        List<Package> updatedStatusList = statusMap.getOrDefault(newStatus, new ArrayList<>());
        updatedStatusList.add(updatedPackage);
        statusMap.put(newStatus, updatedStatusList);

        return true;
    }

    // Get all packages for a sender
    List<Package> getPackagesBySender(String senderId) {
        if (senderId == null || senderId.equals("")) {
            return new ArrayList<>();
        }

        return senderMap.getOrDefault(senderId, new ArrayList<>());
    }

    // Get all packages for a receiver
    List<Package> getPackagesByReceiver(String receiverId) {
        if (receiverId == null || receiverId.equals("")) {
            return new ArrayList<>();
        }

        return receiverMap.getOrDefault(receiverId, new ArrayList<>());
    }

    // Get all packages with a specific status
    List<Package> getPackagesByStatus(String status) {
        if (status == null || status.equals("")) {
            return new ArrayList<>();
        }

        return statusMap.getOrDefault(status, new ArrayList<>());
    }

    // Get total weight of all IN_TRANSIT packages
    double getTotalWeightInTransit() {
        double weightSum = 0;

        List<Package> inTransitList = statusMap.getOrDefault("IN_TRANSIT", new ArrayList<>());

        for (int i = 0; i < inTransitList.size(); i++) {
            weightSum += inTransitList.get(i).getWeight();
        }

        return weightSum;
    }

    // Get most recent failed package
    // Return null if none
    Package getLastFailedPackage() {
        List<Package> failedList = statusMap.getOrDefault("FAILED", new ArrayList<>());

        if (failedList == null || failedList.size() == 0) {
            return null;
        }

        failedList.sort((a, b) -> b.getPackageId() - a.getPackageId());

        return failedList.get(0);
    }

}
