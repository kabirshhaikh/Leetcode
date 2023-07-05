import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[] nums = {3,2,3};
        int test = majorityElement(nums);
        System.out.println(test);
    }

    public static int majorityElement (int[] nums) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums[i];
            myMap.put(currentNumber, myMap.getOrDefault(currentNumber, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int value = map.getValue();
            int key = map.getKey();
            if (value > nums.length/2) {
                return key;
            }
        }
        return -1;
    }

}