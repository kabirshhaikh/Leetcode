public class ListNode {
    Node head;
    Node tail;
    int length;
    class Node {
        int value;
        Node next;
        Node (int value) {
            this.value = value;
        }
    }

    //ListNode constructor:
    ListNode () {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    //Add new node:
    public void addNode (int value) {
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

    //Print LinkedList:
    public void printList () {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + ", ");
            temp = temp.next;
        }
    }

    //Get a node:
    public Node get (int index) {
        Node temp = head;
        if (index < 0 || index >= length) {
            return null;
        }
        else {
            for (int i=0; i<index; i++) {
                temp = temp.next;
            }
        }
        return temp;
    }

    //Set a Node:
    public boolean set (int index, int value) {
        Node temp = get(index);
        if (index < 0 || index >= length) {
            return false;
        }
        else {
            while (temp != null) {
                temp.value = value;
                return true;
            }
        }
        return false;
    }

    //Remove a Node:
    public Node remove (int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length = length - 1;
        return temp;
    }

    public Node removeDuplicate () {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.value == current.next.value) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
        return head;
    }


}
