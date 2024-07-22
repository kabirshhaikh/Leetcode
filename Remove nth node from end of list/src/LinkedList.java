public class LinkedList {
    ListNode head;

    public void addNode(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void printList() {
        ListNode temp = this.head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode size = head;
        int sizeOfList = 0;
        while (size != null) {
            sizeOfList = sizeOfList + 1;
            size = size.next;
        }

        ListNode temp = dummy;
        for (int i = 0; i < sizeOfList - n - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            return null;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }

        return dummy.next;
    }


}
