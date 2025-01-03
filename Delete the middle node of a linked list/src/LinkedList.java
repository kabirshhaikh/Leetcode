public class LinkedList {
    ListNode head;

    public void addNode (int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        }
        else {
            ListNode temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    public void printList () {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public ListNode deleteMiddle (ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode nodeBeforeSlow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        while (nodeBeforeSlow.next != slow) {
            nodeBeforeSlow = nodeBeforeSlow.next;
        }

        nodeBeforeSlow.next = nodeBeforeSlow.next.next;

        return head;
    }



}
