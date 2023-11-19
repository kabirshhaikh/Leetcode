public class Main {
    public static void main (String[] args) {
        ListNode newNode1 = new ListNode(1);
        ListNode newNode2 = new ListNode(3);
        ListNode newNode3 = new ListNode(4);
        ListNode newNode4 = new ListNode(7);
        ListNode newNode5 = new ListNode(1);
        ListNode newNode6 = new ListNode(2);
        ListNode newNode7 = new ListNode(6);

        newNode1.next = newNode2;
        newNode2.next = newNode3;
        newNode3.next = newNode4;
        newNode4.next = newNode5;
        newNode5.next = newNode6;
        newNode6.next = newNode7;

        System.out.println("Before deleting the middle node:");
        newNode1.printList(newNode1);

        System.out.println(" ");

        System.out.println("After deleting the middle node:");
        newNode1.deleteMiddle(newNode1);

        newNode1.printList(newNode1);



    }
}