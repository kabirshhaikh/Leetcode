public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        flatten(root);

        TreeNode curr = root;
        while (curr != null) {
            System.out.print(curr.val + " → ");
            curr = curr.right;
        }
        System.out.print("null");
    }

    public static void flatten(TreeNode root) {
        //base case:
        if (root == null) {
            return;
        }

        //second base case for leaf node:
        if (root.left == null && root.right == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        //now i will define temp which points at root.left if not null:
        if (root.left != null) {
            TreeNode temp = root.left;

            //now find the tail of left:
            while (temp.right != null) {
                temp = temp.right;
            }

            //now point tail.right to root.right:
            temp.right = root.right;

            //now point root.right to root.left:
            root.right = root.left;

            //make the left of root as null:
            root.left = null;
        }

        return;
    }
}
