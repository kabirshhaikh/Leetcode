public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        int value = 2;
        searchBST(root, value);
    }


    public static TreeNode searchBST(TreeNode root, int val) {
        TreeNode leftSubtree = null;
        TreeNode rightSubtree = null;

        if (root == null) {
            return null;
        }


        if (val < root.val) {
            leftSubtree = searchBST(root.left, val);
        }

        if (root.val == val) {
            return root;
        }

        if (val > root.val) {
            rightSubtree = searchBST(root.right, val);
        }

        if (leftSubtree != null) {
            return leftSubtree;
        } else if (rightSubtree != null) {
            return rightSubtree;
        } else {
            return null;
        }
    }
}
