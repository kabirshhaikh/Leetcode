public class Main {
    static int minDiff = Integer.MAX_VALUE;
    static Integer previous = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int result = minDiffInBST(root);

        System.out.println("Minimum Difference: " + result);
    }

    public static int minDiffInBST(TreeNode root) {
        dfs(root);
        return minDiff;
    }

    public static void dfs(TreeNode root) {
        //base case:
        if (root == null) {
            return;
        }

        //perform inorder: LEFT CURRENT RIGHT:
        dfs(root.left);

        int current = root.val;
        if (previous != null) {
            minDiff = Math.min(minDiff, Math.abs(current - previous));
        }

        previous = current;

        dfs(root.right);
    }
}
