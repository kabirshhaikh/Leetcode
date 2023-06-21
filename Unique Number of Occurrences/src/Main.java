import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        int arr[] = {1,2,2,1,1,3};
        boolean test = uniqueOccurrences(arr);
        System.out.println(test);
    }

    public static boolean uniqueOccurrences (int[] arr) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            int currentNumber = arr[i];
            myMap.put(currentNumber, myMap.getOrDefault(currentNumber, 0) + 1);
        }
        HashSet<Integer> mySet = new HashSet<>();
        for (int value : myMap.values()) {
           if (!mySet.contains(value)) {
               mySet.add(value);
           }
           else {
               return false;
           }
        }
        return true;
    }

}