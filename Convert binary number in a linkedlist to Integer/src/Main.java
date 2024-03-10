public class Main {
    public static void main (String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;

        LinkedList list = new LinkedList();
        list.head = node1;

        System.out.println(list.getDecimalValue(list.head));
    }
}