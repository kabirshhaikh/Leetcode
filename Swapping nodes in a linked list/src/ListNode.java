import java.util.ArrayList;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode (int value) {
        this.val = value;
    }

    public void printList (ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + ", ");
            temp = temp.next;
        }
    }


    public ListNode swapNodes (ListNode head, int k) {
        ArrayList<Integer> myList = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {
            myList.add(temp.val);
            temp = temp.next;
        }

        if (k <= 0 || k > myList.size()) {
            return head;
        }

        int tempValue = myList.get(k - 1);
        myList.set(k - 1, myList.get(myList.size() - k));
        myList.set(myList.size() - k, tempValue);

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        for (int i=0; i<myList.size(); i++) {
            current.next = new ListNode(myList.get(i));
            current = current.next;
        }

        return dummy.next;
    }

}
