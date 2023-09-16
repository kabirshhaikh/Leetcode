import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main (String[] args) {
        int[] arr = {40,10,20,30};
        int[] test = arrayRankTransform(arr);
        System.out.println(Arrays.toString(test));
    }


    public static int[] arrayRankTransform (int[] arr) {
        int[] copyArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copyArr);
        HashMap<Integer, Integer> myMap = new HashMap<>();
        int rank = 1;
        for (int i=0; i< copyArr.length; i++) {
            if (!myMap.containsKey(copyArr[i])) {
                myMap.put(copyArr[i], rank);
                rank = rank + 1;
            }
        }
        int[] result = new int[arr.length];
        for (int i=0; i<arr.length; i++) {
            result[i] = myMap.get(arr[i]);
        }
        return result;
    }
}