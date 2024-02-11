import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[] nums = {10,100,101,101};
        int target = 101;
        boolean test = isMajorityElement(nums, target);
        System.out.println(test);
    }


    public static boolean isMajorityElement (int[] nums, int target) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        int arrayLength = nums.length /2;

        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums[i];
            myMap.put(currentNumber, myMap.getOrDefault(currentNumber, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int key = map.getKey();
            int count = map.getValue();
            if (key == target && count > arrayLength) {
                return true;
            }
        }

        return false;
    }
}