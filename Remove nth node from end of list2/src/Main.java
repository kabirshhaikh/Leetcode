public class Main {
    public static void main (String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.insertHead(1);
        linkedList.insertNewNode(2);
        linkedList.insertNewNode(3);
        linkedList.insertNewNode(4);
        linkedList.insertNewNode(5);

        System.out.println("Before removing the node:");
        linkedList.printList();

        System.out.println(" ");
        System.out.println("After removing the node");
        ListNode outputHead = removeNthFromEnd(linkedList.head, 2);

        MyLinkedList output = new MyLinkedList();
        output.head = outputHead;
        output.printList();
    }

    public static ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i=0; i<=n ; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
