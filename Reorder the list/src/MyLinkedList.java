import java.util.Stack;

public class MyLinkedList {
    ListNode head;

    public void addHead(int val) {
        ListNode newNode = new ListNode(val);
        head = newNode;
    }

    public void addNode(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }

        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    public void printList() {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print(" -> ");
            }

            temp = temp.next;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        //1->2->3->4->5
        Stack<ListNode> stack = new Stack<>();
        //5, 4, 3, 2, 1
        ListNode iterate = head;

        while (iterate != null) {
            stack.push(iterate);
            iterate = iterate.next;
        }

        ListNode temp = head;
        int countOfOperations = stack.size() / 2;

        while (countOfOperations > 0) {
            ListNode poppedNode = stack.pop();
            poppedNode.next = temp.next;
            temp.next = poppedNode;
            temp = temp.next.next;
            countOfOperations--;
        }

        if (temp != null) {
            temp.next = null;
        }
    }
}
