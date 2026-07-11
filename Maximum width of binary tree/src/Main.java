import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right.right = new TreeNode(9);

        int answer = widthOfBinaryTree(root);

        System.out.println(answer);
    }

    public static int widthOfBinaryTree(TreeNode root) {
        //if node is null i return 0 as maxWidth;
        if (root == null) {
            return 0;
        }

        //output variable:
        int output = -1;

        //here i define a queue which holds an Object[] where 0th is TreeNode and 1st is index:
        Queue<Object[]> q = new ArrayDeque<>();

        //at this point root is not null so i add it to q with index 0:
        q.offer(new Object[]{root, 1L});

        //now i run the while loop until q is not empty:
        while (!q.isEmpty()) {
            int size = q.size(); // curr level's size snapshot:

            long first = 0;
            long last = 0;
            for (int i = 0; i < size; i++) {
                //here i pop the Object array from q:
                Object[] popped = q.poll();

                TreeNode poppedNode = (TreeNode) popped[0];
                long nodeIndex = (long) popped[1];

                //meaning 1st element in q on this level:
                if (i == 0) {
                    first = nodeIndex;
                }

                //meaning last element in the q:
                if (i == size - 1) {
                    last = nodeIndex;
                }

                //here i add the left and right children to q:
                if (poppedNode.left != null) {
                    q.offer(new Object[]{poppedNode.left, 2 * nodeIndex});
                }

                if (poppedNode.right != null) {
                    q.offer(new Object[]{poppedNode.right, 2 * nodeIndex + 1});
                }
            }

            output = Math.max(output, (int) (last - first + 1));
        }

        return output;
    }
}
