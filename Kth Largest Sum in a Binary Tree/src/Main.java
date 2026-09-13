import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main (String[] args) {
        TreeNode root = new TreeNode(5, null, null);

        root.left = new TreeNode(8, null, null);
        root.right = new TreeNode(9, null, null);

        root.left.left = new TreeNode(2, null, null);
        root.left.right = new TreeNode(1, null, null);

        root.right.left = new TreeNode(3, null, null);
        root.right.right = new TreeNode(7, null, null);

        root.left.left.left = new TreeNode(4, null, null);
        root.left.left.right = new TreeNode(6, null, null);

        int k = 2;

        System.out.println(kthLargestLevelSum(root, k));
    }

    public static long kthLargestLevelSum (TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<TreeNode> q = new ArrayDeque<>();

        //push root to q:
        q.offer(root);

        //run while loop:
        while (!q.isEmpty()) {
            int size = q.size();
            long sum = 0;

            //run loop less than size time:
            for (int i=0; i<size; i++) {
                //pop current node:
                TreeNode poppedNode = q.poll();
                sum += poppedNode.val;

                //edge case:
                if (poppedNode.left != null) {
                    q.offer(poppedNode.left);
                }

                if (poppedNode.right != null) {
                    q.offer(poppedNode.right);
                }
            }

            //first add the sum into pq:
            pq.offer(sum);

            //if pq size > k then poll:
            if (pq.size() > k) {
                pq.poll();
            }
        }

        if (pq.size() == k) {
            return pq.poll();
        }
        else {
            return -1;
        }
    }
}

// bfs:
// q =  [6]
// priority queue. = [5, 17, 13, 10] -> [17, 13, 10, 5]
// while q is not empty:
// int size = q.size(); -> 2
// sum = 10;
// for i=0 i<size
// q.poll(); 6
// sum = sum + popped nodes value
// if popped nodes left is not null then add that to list
// if popped nodes right is not null then add that to list
