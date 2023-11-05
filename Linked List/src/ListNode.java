public class ListNode {
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

    ListNode (int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void appendNode (int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast () {

        if (length == 0) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        while (fast.next != null) {
            slow = fast;
            fast = fast.next;
        }
        tail = slow;
        tail.next = null;
        length = length - 1;
        return tail;
    }

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

    public Node removeFirst () {
        Node temp = head;
        if (length == 0) {
            return null;
        }
        else {
            head = head.next;
            temp.next = null;
        }
        length = length - 1;
        return temp;
    }

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

    public boolean set (int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert (int index, int value) {
        Node newNode = new Node(value);
        if (index < 0 || index >= length ) {
            return false;
        }
        if (index == 0) {
            prepend(value);
            return true;
        }
        else if (index == length) {
            appendNode(value);
            return true;
        }
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length = length + 1;
        return true;
    }


    public Node remove (int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        if  (index == length - 1) {
            removeLast();
        }
        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length = length - 1;
        return temp;
    }

    public void reverse () {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = tail.next;
        Node before = null;
        for (int i=0; i<length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public void printListNode () {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + ", ");
            temp = temp.next;
        }
    }



}