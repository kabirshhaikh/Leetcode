import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        TreeNode root = new TreeNode();
        List<Integer> myList = new ArrayList<>();
        myList = preorderTraversal(root);
        for (int i=0; i<myList.size(); i++) {
            System.out.print(myList.get(i) + ", ");
        }
    }


    public static List<Integer> preorderTraversal (TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode temp = root;
        return traversePreOrder(temp, list);
    }

    public static List<Integer> traversePreOrder(TreeNode temp, ArrayList<Integer> list) {
        if (temp == null) {
            return list;
        }
        list.add(temp.val);
        traversePreOrder(temp.left, list);
        traversePreOrder(temp.right, list);

        return list;
    }
}
