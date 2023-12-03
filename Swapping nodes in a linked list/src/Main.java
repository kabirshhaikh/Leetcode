public class Main {
    public static void main (String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println("Before making the swaps:");
        node1.printList(node1);
        System.out.println(" ");
        node1.swapNodes(node1, 2);
        System.out.println("After swapping the nodes");
        node1.printList(node1);


    }
}