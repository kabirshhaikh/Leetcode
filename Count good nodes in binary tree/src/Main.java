public class Main {
    static int count = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        int ans = goodNodes(root);
        System.out.println(ans);
    }

    public static int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return count;
    }

    public static void dfs(TreeNode root, int maxSoFar) {
        //base case:
        if (root == null) {
            return;
        }

        //check if current nodes val is bigger than maxSoFar:
        if (root.val >= maxSoFar) count++;

        //update the maxsoFar:
        maxSoFar = Math.max(root.val, maxSoFar);

        //recurse left and right:
        dfs(root.left, maxSoFar);
        dfs(root.right, maxSoFar);
    }
}
