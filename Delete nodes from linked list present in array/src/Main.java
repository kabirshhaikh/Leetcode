public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] headArr = {1, 2, 3, 4, 5};

        Solution newSol = new Solution();
        ListNode head = buildLinkedList(headArr);
        ListNode newHead = newSol.modifiedList(nums, head);

        System.out.println("Modified Linked List: ");
        printList(newHead);
    }

    public static ListNode buildLinkedList(int[] head) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int i = 0; i < head.length; i++) {
            ListNode newNode = new ListNode(head[i]);
            curr.next = newNode;
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.println(temp.val);
            if (temp.next != null) System.out.print("->");
            temp = temp.next;
        }
        System.out.println("");
    }
}
