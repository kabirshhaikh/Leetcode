import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        connect(root);

        Node levelStart = root;

        while (levelStart != null) {
            Node current = levelStart;

            while (current != null) {
                System.out.print(current.val + " -> ");
                current = current.next;
            }

            System.out.println("null");

            levelStart = levelStart.left;
        }
    }

    public static Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node popped = q.poll();

                //first add the left and right children to q:
                if (popped.left != null) {
                    q.offer(popped.left);
                }

                if (popped.right != null) {
                    q.offer(popped.right);
                }

                //now point this popped node's next to next:
                //if index i is at last element then let it point to null:
                if (i == size - 1) {
                    popped.next = null;
                } else {
                    //else next will point at next element from q:
                    //i will use peek instead of popping the element
                    popped.next = q.peek();
                }
            }
        }

        return root;
    }
}
