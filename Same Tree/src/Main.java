public class Main {
    public static void main (String[] args) {
        TreeNode p = new TreeNode();
        TreeNode q = new TreeNode();
        boolean test = isSameTree(p, q);
        System.out.println(test);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        TreeNode pTemp = p;
        TreeNode qTemp = q;
        return traverse(pTemp, qTemp);
    }

    public static boolean traverse(TreeNode pTemp, TreeNode qTemp) {
        if (pTemp == null && qTemp == null) {
            return true;
        }
        if (pTemp == null || qTemp == null) {
            return false;
        }
        if (pTemp.val != qTemp.val) {
            return false;
        }
        boolean left = traverse(pTemp.left, qTemp.left);
        boolean right = traverse(pTemp.right, qTemp.right);
        return left && right;
    }
}
