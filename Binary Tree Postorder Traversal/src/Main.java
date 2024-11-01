import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        TreeNode root = new TreeNode();
        List<Integer> list = new ArrayList<>();
        list = postorderTraversal(root);
        for (int i=0; i<list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode temp = root;
        return traverse(temp, list);
    }

    public static List<Integer> traverse (TreeNode temp, List<Integer> list ) {
        if (temp == null) {
            return list;
        }
        traverse(temp.left, list);
        traverse(temp.right, list);
        list.add(temp.val);
        return list;
    }
}
