
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);

        int test = countNodes(root);
        System.out.println(test);
    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSubTree = countNodes(root.left);
        int rightSubTree = countNodes(root.right);

        return 1 + (leftSubTree + rightSubTree);
    }
}
