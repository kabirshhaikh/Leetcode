public class Main {
    public static void main (String[] args) {
        LinkedList myLinkedList = new LinkedList();
        myLinkedList.insertNode(1);
        myLinkedList.insertNode(1);
        myLinkedList.insertNode(2);
        myLinkedList.insertNode(1);
        myLinkedList.insertNode(2);
        myLinkedList.insertNode(3);
        LinkedList result = myLinkedList.frequenciesOfElements(myLinkedList.head);
        result.printList();
    }
}
