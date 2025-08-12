import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {2, 3, 4}, {2, 3, 5}};
        int test = smallestCommonElement(mat);
        System.out.println(test);
    }

    public static int smallestCommonElement(int[][] mat) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        int numberOfRows = mat.length;
        int output = Integer.MAX_VALUE;

        for (int i = 0; i < mat.length; i++) {
            int[] current = mat[i];
            for (int j = 0; j < current.length; j++) {
                myMap.put(current[j], myMap.getOrDefault(current[j], 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int key = map.getKey();
            int count = map.getValue();
            if (count == numberOfRows) {
                output = Math.min(output, key);
            }
        }


        return output == Integer.MAX_VALUE ? -1 : output;
    }
}
