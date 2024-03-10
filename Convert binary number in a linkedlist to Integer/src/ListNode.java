 class ListNode {
    int value;
    ListNode next;

    ListNode (int val) {
        this.value = val;
        this.next = null;
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
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public int getDecimalValue (ListNode head) {
        int output = 0;
        StringBuilder sb = new StringBuilder();
        ListNode temp = head;

        while (temp != null) {
            int currentNumber = temp.value;
            String number = String.valueOf(currentNumber);
            sb.append(number);
            temp = temp.next;
        }

        output = Integer.parseInt(sb.toString(), 2);
        return output;
    }

}
