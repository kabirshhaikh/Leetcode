import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);

        List<TreeNode> result = findDuplicateSubtrees(root);

        for (TreeNode node : result) {
            System.out.println(node.val);
        }
    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> map = new HashMap<>();
        List<TreeNode> list = new ArrayList<>();

        dfs(root, list, map);

        return list;
    }

    public static String dfs(TreeNode root, List<TreeNode> list, HashMap<String, Integer> map) {
        //base case:
        if (root == null) {
            return "#";
        }


        String leftTree = dfs(root.left, list, map);
        String current = Integer.toString(root.val);
        String rightTree = dfs(root.right, list, map);

        String currentLevelString = current + "," + leftTree + "," + rightTree;

        map.put(currentLevelString, map.getOrDefault(currentLevelString, 0) + 1);

        if (map.get(currentLevelString) == 2) {
            list.add(root);
        }

        return currentLevelString;
    }
}
