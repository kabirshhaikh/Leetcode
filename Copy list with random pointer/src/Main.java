public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        Node node1 = list.addHead(1);
        Node node2 = list.addNode(2);
        Node node3 = list.addNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        node1.random = null;
        node2.random = node1;
        node3.random = null;

        System.out.println("Original List:");
        list.print();

        Node copyHead = list.copyRandomList(node1);
        System.out.println("\nCopied List:");
        printListWithRandoms(copyHead);
    }

    public static void printListWithRandoms(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print("Node " + temp.val);
            if (temp.random != null) {
                System.out.print(" (random -> " + temp.random.val + ")");
            } else {
                System.out.print(" (random -> null)");
            }
            System.out.println();
            temp = temp.next;
        }
    }
}
