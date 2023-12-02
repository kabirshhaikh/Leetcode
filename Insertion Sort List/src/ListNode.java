import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ListNode {
    int val;
    ListNode next;

    ListNode () {

    }

    ListNode (int value) {
        this.val = value;
    }

    public ListNode insertionSortList (ListNode head) {
        ListNode dummy = new ListNode();
        ListNode curr = head;

        while (curr != null) {
            // At each iteration, we insert an element into the resulting list.
            ListNode prev = dummy;

            // find the position to insert the current node
            while (prev.next != null && prev.next.val <= curr.val) {
                prev = prev.next;
            }

            ListNode next = curr.next;
            // insert the current node to the new list
            curr.next = prev.next;
            prev.next = curr;

            // moving on to the next iteration
            curr = next;
        }

        return dummy.next;
    }

    public void printList (ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + ", ");
            temp = temp.next;
        }
    }

}
