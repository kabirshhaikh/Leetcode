import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode () {}
    TreeNode (int value) {
        this.val = value;
    }

    public int[] findMode (TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        HashMap<Integer, Integer> myMap = new HashMap<>();
        ArrayList<Integer> myList = new ArrayList<>();

        findModeHelper(root, myMap);

        int maxFreq = 0;

        for (Map.Entry<Integer, Integer> map: myMap.entrySet()) {
            int count = map.getValue();
            maxFreq = Math.max(maxFreq, count);
        }

        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int key = map.getKey();
            int count = map.getValue();
            if (count == maxFreq) {
                myList.add(key);
            }
        }

        int[] finalOutput = new int[myList.size()];

        for (int i=0; i<myList.size(); i++) {
            finalOutput[i] = myList.get(i);
        }

        return finalOutput;
    }

    private void findModeHelper (TreeNode root, Map<Integer, Integer> myMap) {
        if (root != null) {
            myMap.put(root.val, myMap.getOrDefault(root.val, 0) + 1);
            findModeHelper(root.left, myMap);
            findModeHelper(root.right, myMap);
        }
    }

}
