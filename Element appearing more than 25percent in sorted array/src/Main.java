import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[] arr = {1,2,2,6,6,6,6,7,10};
        int test = findSpecialInteger(arr);
        System.out.println(test);
    }

    public static int findSpecialInteger (int[] arr) {
        HashMap<Integer, Integer> myMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int currentElement = arr[i];
            myMap.put(currentElement, myMap.getOrDefault(currentElement, 0) + 1);
        }

        int totalElements = arr.length;
        int threshold = totalElements / 4;

        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int count = map.getValue();
            if (count > threshold) {
                return map.getKey();
            }
        }

        return -1;
    }

}