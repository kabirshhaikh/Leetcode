public class Main {
    public static void main (String[] args) {
        LinkedList list = new LinkedList();
        list.addNode(1);
        list.addNode(3);
        list.addNode(4);
        list.addNode(7);
        list.addNode(1);
        list.addNode(2);
        list.addNode(6);
        System.out.println("List before deleting the middle node:");
        list.printList();
        System.out.println(" ");
        System.out.println("Deleting the middle node:");
        list.deleteMiddle(list.head);
        list.printList();
    }
}
