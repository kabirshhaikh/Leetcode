public class Main {
    public static void main (String[] args) {
        LinkedList list = new LinkedList();

        list.head.next = new ListNode(0);
        list.head.next.next = new ListNode(2);
        list.head.next.next.next = new ListNode(-5);
        list.head.next.next.next.next = new ListNode(5);
        list.head.next.next.next.next.next = new ListNode(10);
        list.head.next.next.next.next.next.next = new ListNode(-10);

        System.out.println("Original List:");
        list.printList();

        list.head = list.sortLinkedList(list.head);

        System.out.println("Sorted List:");
        list.printList();
    }
}