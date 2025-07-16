public class Main {
    public static void main (String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addHead(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        System.out.println("Before Reordering the list:");
        list.printList();

        System.out.println(" ");
        System.out.println("Re-ordered list:");
        list.reorderList(list.head);
        list.printList();
    }
}
