import java.util.ArrayList;

public class ListNode {
    int value;
    ListNode next;

    ListNode () {

    }

    ListNode (int val) {
        this.value = val;
    }

    //Function to sort the Linked List:
    public ListNode sortList (ListNode head) {
        ArrayList<Integer> myList = new ArrayList<>();
        ListNode temp = head;

        //Here I am storing values of the LinkedList into arrayList:
        while (temp != null) {
            myList.add(temp.value);
            temp = temp.next;
        }

        //Create a dummy listnode as a start point:
        ListNode dummy = new ListNode(-1);

        //Create an another ListNode which will traverse and make the sorted linked list:
        ListNode current = dummy;

        for (int i=0; i<myList.size(); i++) {
            current.next = new ListNode(myList.get(i));
            current = current.next;
        }

        return dummy.next;
    }

    //Function to print the list:
    public void printList (ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.print(temp.value + ", ");
            temp = temp.next;
        }
    }


}
