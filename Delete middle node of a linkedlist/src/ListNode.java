public class ListNode {
    ListNode next;
    int val;
    ListNode () {}
    ListNode (int value) {
        val = value;
    }
    ListNode (int value, ListNode next) {
        this.val = value;
        this.next = next;
    }

    public void append (int value) {
        ListNode newNode = new ListNode (value);
        if (this.next == null) {
            this.next = newNode;
        }
        else {
            ListNode current = this;
            while (current != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public ListNode deleteMiddle (ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = slow.next;
        }
        else {
            head = head.next;
        }
        return head;
    }

    public void printList (ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.print(temp.val + ", ");
            temp = temp.next;
        }
    }

}
