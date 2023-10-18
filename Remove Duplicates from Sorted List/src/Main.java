public class Main {
    public static void main (String[] args) {
        ListNode list = new ListNode();
        list.addNode(1);
        list.addNode(1);
        list.addNode(2);
        list.addNode(2);
        list.addNode(3);
        list.addNode(3);
        list.removeDuplicate();
        list.printList();
    }
}
