import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] agrs) {
        int[][] mat = {{0,0,0}, {0,1,1}};
        int[] test = rowAndMaximumOnes(mat);
        System.out.println(Arrays.toString(test));
    }

    public static int[] rowAndMaximumOnes (int[][] mat) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int[] currentArray = mat[i];
            int currentIndex = i;
            int counter = 0;
            for (int j = 0; j < currentArray.length; j++) {
                if (currentArray[j] == 1) {
                    counter = counter + 1;
                }
            }
            myMap.put(currentIndex, counter);
        }
        int finalKey = 0;
        int finalValue = 0;
        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int key = map.getKey();
            int value = map.getValue();
            if (value > finalValue) {
                finalKey = key;
                finalValue = value;
            }
        }
        int[] outputArray = new int[2];
        outputArray[0] = finalKey;
        outputArray[1] = finalValue;
        return outputArray;
    }

}
