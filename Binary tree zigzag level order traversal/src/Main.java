import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = zigzagLevelOrder(root);

        System.out.println(result);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //so first i define an empty output list of list:
        List<List<Integer>> output = new ArrayList<>();

        //base check:
        if (root == null) {
            return output;
        }

        //now here i define a queue:
        Queue<TreeNode> q = new ArrayDeque<>();

        //here i define another variable to track current level:
        int level = 0;

        //at this point root is not null so i add it to q:
        q.offer(root);

        //now i run a while loop until q is not empty:
        while (!q.isEmpty()) {
            int size = q.size(); //here i capture current size of q:

            //temp will hold nodes from current level:
            List<Integer> temp = new ArrayList<>();

            //then i run for loop starting at 0 until less than size:
            //each iteration i pop treenode, check if its left and right child
            //are not null, then add it to q and add popped root.val to temp:
            for (int i = 0; i < size; i++) {
                TreeNode popped = q.poll(); //popped node

                //if left child is not null, add it to q:
                if (popped.left != null) q.offer(popped.left);

                //if right child is not null, add it to q:
                if (popped.right != null) q.offer(popped.right);

                //then i add popped roots value into temp:
                temp.add(popped.val);
            }

            //if current level is even then add list left to right:
            if (level % 2 == 0) {
                output.add(temp);
            }
            //if the level is odd then reverse the list meaning right to left and add it to the output list:
            else {
                Collections.reverse(temp);
                output.add(temp);
            }

            //after performing above steps increment level:
            level++;
        }

        //in the end i just return the output:
        return output;
    }
}
