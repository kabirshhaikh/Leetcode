public class MyLinkedList {
    Node head;

    public Node addHead(int val) {
        Node newNode = new Node(val);
        head = newNode;
        return newNode;
    }

    public Node addNode(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            return newNode;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return newNode;
    }

    public void print() {
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

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        //Step 1: Here I am creating a copy and placing it next to the original node
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        //1->1'->2->2'->3->3'
        //1.random = null; 2.random = 1; 3.random = null;
        //Step 2: Here I am assigning copy.random to copy of original.random
        Node temp2 = head;
        while (temp2 != null) {
            if (temp2.random != null) {
                temp2.next.random = temp2.random.next;
            } else {
                temp2.next.random = null;
            }

            temp2 = temp2.next.next;
        }

        //Step 3: Here I am restoring the original list and extracting the deep copy of list
        Node original = head;
        Node copyHead = head.next != null ? head.next : null;
        Node copy = copyHead;

        while (original != null) {
            original.next = original.next.next; //this extracts the original link
            copy.next = (copy.next != null) ? copy.next.next : null; //this extracts the deep copy
            original = original.next;
            copy = copy.next;
        }

        return copyHead;
    }
}
