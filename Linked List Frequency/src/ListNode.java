import java.util.HashMap;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;

    ListNode (int value) {
        this.val = value;
    }

    ListNode (int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

 class LinkedList {
    ListNode head;
    LinkedList () {
        this.head = null;
    }

    public void printList () {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + ", ");
            temp = temp.next;
        }
    }


    public void insertNode (int value) {
        ListNode newNode = new ListNode(value);
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

    public LinkedList frequenciesOfElements (ListNode head) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        LinkedList newList = new LinkedList();

        ListNode temp = head;

        while (temp != null) {
            int currentVal = temp.val;
            myMap.put(currentVal, myMap.getOrDefault(currentVal, 0) + 1);
            temp = temp.next;
        }

        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int count = map.getValue();
            newList.insertNode(count);
        }

        return newList;
    }



}
