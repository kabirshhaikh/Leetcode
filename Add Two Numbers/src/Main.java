public class Main {
    public static void main(String[] args) {
        MyLinkedList l1 = new MyLinkedList();
        l1.insertNode(2);
        l1.insertNode(4);
        l1.insertNode(3);

        MyLinkedList l2 = new MyLinkedList();
        l2.insertNode(5);
        l2.insertNode(6);
        l2.insertNode(4);

        ListNode resultHead = addTwoNumbers(l1, l2);
        MyLinkedList l3 = new MyLinkedList();
        l3.head = resultHead;
        l3.printList();
    }

    public static ListNode addTwoNumbers(MyLinkedList l1, MyLinkedList l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        ListNode pointer1 = l1.head;
        ListNode pointer2 = l2.head;

        int carry = 0;

        while (pointer1 != null || pointer2 != null || carry != 0) {
            int x = (pointer1 != null) ? pointer1.val : 0;
            int y = (pointer2 != null) ? pointer2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;
            int digit = sum % 10;

            ListNode newNode = new ListNode(digit);
            current.next = newNode;
            current = newNode;

            if (pointer1 != null) pointer1 = pointer1.next;
            if (pointer2 != null) pointer2 = pointer2.next;
        }

        return dummy.next;
    }
}
