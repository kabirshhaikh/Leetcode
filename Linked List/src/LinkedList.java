public class LinkedList {
    class Node {
        int value;
        Node next;
        Node (int value) {
            this.value = value;
        }
    }
    Node head;
    Node tail;
    int length;

    //Constructor:
    public LinkedList (int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    //Print Linked List:
    public void printList () {
        Node temp = head;
        System.out.println("Following is the List:");
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    //Get Head:
    public void getHead () {
        System.out.println("Head: " +head.value);
    }

    //Get Tail:
    public void getTail () {
        System.out.println("Tail:" +tail.value);
    }

    //Get Length:
    public void getLength () {
        System.out.println("Length: " +length);
    }

    //Append a node to the Linked List:
    public void append (int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        length = length + 1;
     }

     //Remove Last Node:
    public Node removeLast () {
        Node temp = head;
        Node pre = head;
        if (length == 0) {
            return null;
        }

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length = length - 1;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    //Prepend the node in the LinkedList:
    public void prepend (int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        length = length + 1;
    }

    //Remove first node from the Linked List:
    public Node removeFirst () {
        Node temp = head;
        head = head.next;
        temp.next = null;
        length = length - 1;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

}
