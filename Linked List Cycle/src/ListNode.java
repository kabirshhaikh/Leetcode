public class ListNode {
    int val;
    ListNode next;

    ListNode (int value) {
        val = value;
        next = null;
    }

    public void printList () {
        ListNode head = this;
        ListNode dummy = head;
        while (dummy != null) {
            System.out.print(dummy.val + ", ");
            dummy = dummy.next;
        }
    }

    public boolean hasCycle (ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
