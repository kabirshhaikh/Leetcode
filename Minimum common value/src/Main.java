import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[] nums1 = {1,1,2};
        int[] nums2 = {2,4};
        int test = getCommon(nums1, nums2);
        System.out.println(test);
    }

    public static int getCommon (int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        HashSet<Integer> mySet1 = new HashSet<>();
        HashSet<Integer> mySet2 = new HashSet<>();
        for (int i=0; i< nums1.length; i++) {
            if (!mySet1.contains(nums1[i])) {
                mySet1.add(nums1[i]);
            }
        }
        for (int i=0; i<nums2.length; i++) {
            if (!mySet2.contains(nums2[i])) {
                mySet2.add(nums2[i]);
            }
        }
        Iterator<Integer> iterator1 = mySet1.iterator();
        while (iterator1.hasNext()) {
            int currentNumber = iterator1.next();
            myMap.put(currentNumber, myMap.getOrDefault(currentNumber, 0) + 1);
        }
        Iterator<Integer> iterator2 = mySet2.iterator();
        while (iterator2.hasNext()) {
            int currentNumber = iterator2.next();
            myMap.put(currentNumber, myMap.getOrDefault(currentNumber, 0 ) + 1);
        }
        int smallestNumber = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int value = map.getValue();
            int key = map.getKey();
            if (value > 1 && key < smallestNumber) {
                smallestNumber = key;
            }
        }
        if (smallestNumber == Integer.MAX_VALUE) {
            return -1;
        }
        else {
            return smallestNumber;
        }
    }


}
