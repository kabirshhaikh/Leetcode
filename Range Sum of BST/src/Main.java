public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
        int low = 7;
        int high = 15;
        int test = rangeSumBST(root, low, high);
        System.out.println(test);
    }


    public static int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;

        if (root == null) {
            return 0;
        }

        if (root.val > low) {
            sum = sum + rangeSumBST(root.left, low, high);
        }

        if (root.val >= low && root.val <= high) {
            sum = sum + root.val;
        }

        if (root.val < high) {
            sum = sum + rangeSumBST(root.right, low, high);
        }

        return sum;
    }
}
