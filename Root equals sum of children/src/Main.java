public class Main {
    public static void main (String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
    }

    public static boolean checkTree (TreeNode root) {
        int sum = root.left.val + root.right.val;
        if (sum == root.val) {
            return true;
        }
        return false;
    }
}
