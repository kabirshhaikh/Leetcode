import java.util.*;

public class ListNode {
    int val;
    ListNode next;
    ListNode () {

    }
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

    public ListNode deleteDuplicates (ListNode head) {
        ListNode temp = head;
        HashMap<Integer, Integer> myMap = new HashMap<>();
        ArrayList<Integer> myList = new ArrayList<>();

        while (temp != null) {
            myMap.put(temp.val, myMap.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
        }

        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int key = map.getKey();
            int count = map.getValue();
            if (count <= 1) {
                myList.add(key);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        Collections.sort(myList);

        for (int i=0; i<myList.size(); i++) {
            current.next = new ListNode(myList.get(i));
            current = current.next;
        }

        return dummy.next;
    }

}