public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        System.out.println("Initial List");
        list.printList();

        System.out.println("");
        System.out.println("Remove nth node form end:");
        list.removeNthFromEnd(list.head, 2);
        list.printList();
    }
}
