import java.util.ArrayList;
import java.util.Collections;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}


class LinkedList {
    ListNode head;

    LinkedList () {
        this.head = null;
    }

    public void printList () {
        ListNode temp = head;
        while (temp!=null) {
            System.out.print(temp.val + ", ");
            temp = temp.next;
        }
    }

    public ListNode sortLinkedList (ListNode head) {
        ArrayList<Integer> myList = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            myList.add(temp.val);
            temp = temp.next;
        }

        Collections.sort(myList);

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int value : myList) {
            ListNode newNode = new ListNode(value);
            current.next = newNode;
            current = current.next;
        }
       return dummy.next;
    }

}
