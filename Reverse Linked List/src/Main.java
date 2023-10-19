public class Main {
    public static void main (String[] args) {
        System.out.println("Without reversing a Linked List:");
        ListNode linkedList = new ListNode();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.print();
        System.out.println(" ");
        System.out.println("Reversed Linked List:");
        linkedList.reverse();
        linkedList.print();
    }
}