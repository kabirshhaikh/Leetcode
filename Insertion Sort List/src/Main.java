public class Main {
    public static void main (String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println("Before insertion sort list:");
        node1.printList(node1);
        System.out.println("  ");
        System.out.println("After insertion sort list:");
        node1.insertionSortList(node1);
        node1.printList(node1);
    }
}
