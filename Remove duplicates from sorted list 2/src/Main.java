public class Main {
    public static void main (String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        System.out.println("Before removing the duplicates:");
        node1.printList(node1);

        System.out.println(" ");

        System.out.println("After removing duplicates from the list:");
        node1.deleteDuplicates(node1);
        node1.printList(node1);

    }
}