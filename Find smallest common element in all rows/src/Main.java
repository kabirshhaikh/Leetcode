import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[][] mat = {{1,2,3,4,5}, {2,4,5,8,10}, {3,5,7,9,11}, {1,3,5,7,9}};
        int test = smallestCommonElement(mat);
        System.out.println(test);
    }

    public static int smallestCommonElement (int[][] mat) {
        HashMap<Integer, Integer> myMap = new HashMap<>();

        for (int i=0; i<mat.length; i++) {
            int[] arr = mat[i];
            for (int j=0; j<arr.length; j++) {
                int currentNumber = arr[j];
                myMap.put(currentNumber, myMap.getOrDefault(currentNumber, 0) + 1);
            }
        }

        int outputKey = -1;
        int outputCount = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int key = map.getKey();
            int count = map.getValue();
            if (count > outputCount) {
                outputCount = count;
                outputKey = key;
            }
        }


        if (outputKey == -1) {
            return -1;
        }
        else {
            return outputKey;
        }
    }
}