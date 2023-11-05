public class Main {
    public static void main (String[] args) {
//        LinkedList myLinkedList = new LinkedList(2);
//        myLinkedList.append(3);
//        myLinkedList.printList();
//        myLinkedList.removeLast();
//        myLinkedList.printList();
//        myLinkedList.prepend(1);
//        myLinkedList.printList();
//        myLinkedList.removeFirst();
//        myLinkedList.printList();

        ListNode newListNode = new ListNode(1);
        newListNode.appendNode(2);
        newListNode.appendNode(3);
        newListNode.prepend(0);
        System.out.println(newListNode.get(2).value);
        System.out.println(newListNode.set(2, 7));
        newListNode.insert(1, 20);
        newListNode.remove(1);
//        newListNode.removeLast();
        newListNode.printListNode();
        newListNode.reverse();
        System.out.println(" ");
        newListNode.printListNode();


    }
}


