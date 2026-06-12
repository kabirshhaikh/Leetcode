public class Package {
    private int packageId;
    private String senderId;
    private String receiverId;
    private double weight;
    private String status;

    public Package(int packageId, String senderId, String receiverId, double weight, String status) {
        this.packageId = packageId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.weight = weight;
        this.status = status;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
