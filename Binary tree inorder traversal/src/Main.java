import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        traverse(root);
    }

    public static List<Integer> traverse (TreeNode root) {
        List<Integer> myList = new ArrayList<>();
        inOrderTraversal(root, myList);
        return myList;
    }

    public static void inOrderTraversal (TreeNode root, List<Integer> myList) {
        if (root!=null) {
            inOrderTraversal(root.left, myList);
            myList.add(root.val);
            inOrderTraversal(root.right, myList);
        }
    }
}





