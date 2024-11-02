public class Main {
    public static void  main (String[] args) {
        TreeNode root = new TreeNode();
        int test = maxDepth(root);
        System.out.println(test);
    }


    public static int maxDepth(TreeNode root) {
        TreeNode temp = root;
        int depth = 0;
        return traverse(temp, depth);
    }

    public static int traverse(TreeNode temp, int depth) {
        if (temp == null) {
            return 0;
        }
        depth = depth + 1;
        int leftDepth = traverse(temp.left, depth);
        int rightDepth = traverse(temp.right, depth);
        depth = Math.max(leftDepth, rightDepth) +1 ;
        return depth;
    }
}
