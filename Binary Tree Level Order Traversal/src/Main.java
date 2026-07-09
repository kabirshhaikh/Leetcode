import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = levelOrder(root);

        System.out.println(result);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>(); //this will hold output:

        //if the root itself is null, return output list which is empty:
        if (root == null) {
            return output;
        }

        Queue<TreeNode> q = new ArrayDeque<>();

        //here i add the root the very first val:
        q.add(root);

        //then i run this operation until q is not empty:
        while (!q.isEmpty()) {
            //this gives us how many nodes we need to process at each level:
            int currentLevelSize = q.size();

            //this is temp list which will be added into output:
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < currentLevelSize; i++) {
                //pop current top node:
                TreeNode popped = q.poll();

                //add its neighbours to the q:
                if (popped.left != null) {
                    q.offer(popped.left);
                }

                if (popped.right != null) {
                    q.offer(popped.right);
                }

                //after adding the neighbours to q, add the popped node to temp list:
                temp.add(popped.val);
            }

            output.add(temp);
        }

        return output;
    }
}
