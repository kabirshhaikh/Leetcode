import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] test = intersect(nums1, nums2);
        System.out.println(Arrays.toString(test));
    }

    public static int[] intersect (int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> myMap1 = new HashMap<>();
        HashMap<Integer, Integer> myMap2 = new HashMap<>();
        ArrayList<Integer> myList = new ArrayList<>();
        for (int i=0; i< nums1.length; i++) {
            int currentNumber = nums1[i];
            myMap1.put(currentNumber, myMap1.getOrDefault(currentNumber, 0) + 1);
        }
        for (int i=0; i< nums2.length; i++) {
            int currentNumber = nums2[i];
            myMap2.put(currentNumber, myMap2.getOrDefault(currentNumber, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> map1 : myMap1.entrySet()) {
            for (Map.Entry<Integer, Integer> map2 : myMap2.entrySet()) {
                int key1 = map1.getKey();
                int value1 = map1.getValue();
                int key2 = map2.getKey();
                int value2 = map2.getValue();
                if (key1 == key2) {
                    int intersectionCount = Math.min(value1, value2);
                    for (int i=0; i<intersectionCount; i++) {
                        myList.add(key1);
                    }
                }
            }
        }
        int[] output = new int[myList.size()];
        for (int i=0; i<myList.size(); i++) {
            output[i] = myList.get(i);
        }
        return output;
    }

}
