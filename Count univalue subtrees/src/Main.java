public class Main {
    static int count = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        int ans = countUnivalSubtrees(root);
        System.out.println(ans);
    }

    public static int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return count;
    }

    public static boolean dfs(TreeNode root) {
        //base case:
        if (root == null) {
            return true; //i return true because empty tree is trivially univalue
        }

        //leaf node:
        if (root.left == null && root.right == null) {
            count++;
            return true; //leaf node is uni-value:
        }

        //first recurse left and right:
        boolean leftTree = dfs(root.left);
        boolean rightTree = dfs(root.right);

        //if either subtree is false, then return false:
        if (!leftTree || !rightTree)
            return false;

        //if left node is not null and its val does not match curr then return false:
        if (root.left != null && root.left.val != root.val) {
            return false;
        }

        //if right node is not null and its val does not match curr then return false:
        if (root.right != null && root.right.val != root.val) {
            return false;
        }

        //if above statements are not false then increment count and return true:
        count++;
        return true;
    }
}
