import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[] arr = {1,2,2,3,3,3};
        int test = findLucky(arr);
        System.out.println("Final Answer: " +test);
    }

    public static int findLucky (int[] arr) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        int output = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++) {
            int currentNumber = arr[i];
            myMap.put(currentNumber, myMap.getOrDefault(currentNumber, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int value = map.getValue();
            int key = map.getKey();
            if (value == key) {
                output = key;
            }
        }
        if (output == Integer.MIN_VALUE) {
            return -1;
        }
        else {
            return output;
        }
    }

}