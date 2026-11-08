import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        int result = maxLevelSum(root);
        System.out.println("Maximum Level Sum is at Level: " + result);
    }

    public static int maxLevelSum(TreeNode root) {
        //if root is null thenn return Integer.MAX_VALUE:

        //use queue and push root to it:
        //use a variable called level and set it to 1:

        //run while loop until queue is not empty:
        //->get current size of queue
        //->maintain a sum counter:
        //->run for loop on that size:
        //->pop node
        //->add its value to sum
        //->check if left and rigth are not null then push them into queue
        //once for loop is done, push sum and level into hashmap
        //increment level:
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        Queue<TreeNode> q = new ArrayDeque<>();

        q.offer(root);
        int level = 1;

        int smallestLevel = 1;
        int largestSum = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode popped = q.poll();
                sum += popped.val;

                if (popped.left != null) {
                    q.offer(popped.left);
                }

                if (popped.right != null) {
                    q.offer(popped.right);
                }
            }

            if (sum > largestSum) {
                largestSum = sum;
                smallestLevel = level;
            }

            level++;
        }

        return smallestLevel;
    }
}
