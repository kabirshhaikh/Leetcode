import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> ans = pathSum(root, 22);

        System.out.println(ans);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //base case:
        //if the root is null: return list of list.

        //if root.left == null && root.right == null && root.val == target:
        //then record the list add it to output and return.

        //at each node we add the current value to a list.
        // and then we recurse left and right.
        //after recusring left and right we pop the current node
        //and return the list of list.

        List<List<Integer>> output = new ArrayList<>();
        List<Integer> pathList = new ArrayList<>();

        path(root, pathList, output, targetSum);

        return output;
    }

    public static void path(TreeNode root, List<Integer> pathList, List<List<Integer>> output, int targetSum) {
        //base case: if we reached very end then just return we didnt find the target
        if (root == null) {
            return;
        }

        //if root is leaf and targetSum == root.val then record answer and return:
        if (root.left == null && root.right == null && root.val == targetSum) {
            //add current nodes value into list of reference objct:
            pathList.add(root.val);
            //add a snapshot of pathList into output because pathList if reference, it will get modified:
            output.add(new ArrayList<>(pathList));
            //now remove the current root.val from pathList because our job is done:
            pathList.remove(pathList.size() - 1);
            return;
        }

        //otherwise: add current nodes value to the list:
        pathList.add(root.val);

        //and then do recursion on both left and right:
        path(root.left, pathList, output, targetSum - root.val);
        path(root.right, pathList, output, targetSum - root.val);

        //after exploring both the sides, remove current element from pathList and return so that the
        //calling func before gets the list in exact form how it had before calling current function:
        pathList.remove(pathList.size() - 1);

        return;
    }
}
