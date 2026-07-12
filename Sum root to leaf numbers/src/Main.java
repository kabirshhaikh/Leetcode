public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int ans = sumNumbers(root);
        System.out.println(ans);
    }

    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public static int dfs(TreeNode root, int numberFormed) {
        //base case:
        if (root == null) {
            return 0;
        }

        //base case: meaning leaf node:
        if (root.left == null && root.right == null) {
            return numberFormed * 10 + root.val;
        }

        //if its not the base case then we form the currnumber:
        int currentNumberFormed = numberFormed * 10 + root.val;

        //then we recurse left and right:
        int leftTree = dfs(root.left, currentNumberFormed);
        int rightTree = dfs(root.right, currentNumberFormed);

        //then we return the sum of left and right tree:
        return leftTree + rightTree;
    }
}
