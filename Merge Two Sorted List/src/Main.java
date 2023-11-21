public class Main {
    public static void main (String[] args) {
        ListNode list1node1 = new ListNode(1);
        ListNode list1node2 = new ListNode(2);
        ListNode list1node3 = new ListNode(4);

        list1node1.next = list1node2;
        list1node2.next = list1node3;


        ListNode list2Node1 = new ListNode(1);
        ListNode list2Node2 = new ListNode(3);
        ListNode list2Node3 = new ListNode(4);

        list2Node1.next = list2Node2;
        list2Node2.next = list2Node3;

        ListNode printListNode = list1node1.mergeTwoLists(list1node1, list2Node1);
        printListNode.printList(printListNode);
    }
}