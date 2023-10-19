public class ListNode {
    class Node {
        int val;
        Node next;
        Node (int val) {
            this.val = val;
        }
    }
    Node head;
    Node tail;
    int length;

    ListNode () {
        this.head = null;
        this.tail = null;
        length = 0;
    }

    public void append (int val) {
        Node newNode = new Node(val);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length = length + 1;
    }

    public Node reverse () {
        int length = 0;
        Node lengthNode = head;
        //To get length of the linkedlist:
        while (lengthNode != null) {
            length = length + 1;
            lengthNode = lengthNode.next;
        }

        Node current = head;
        Node prev = null;
        Node after = null;

        while (current != null) {
            after = current.next;
            current.next = prev;
            prev = current;
            current = after;
        }
        head = prev;
        return head;
    }

    public void print () {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + ", ");
            temp = temp.next;
        }
    }

}
