import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[] nums = {3, 4, 4, 1, 2, 1};
        boolean test = isGood(nums);
        System.out.println(test);
    }


    private static boolean isGood (int[] nums) {
        if (nums.length - 1 < 1) {
            return false;
        }

        HashMap<Integer, Integer> myMap = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums[i];
            myMap.put(currentNumber, myMap.getOrDefault(currentNumber, 0 ) + 1);
        }

        for (int i=1; i<nums.length - 1; i++) {
            if (!myMap.containsKey(i) || myMap.get(i) != 1) {
                return false;
            }
        }

        if (myMap.getOrDefault(nums.length - 1, 0) == 2 && myMap.size() == nums.length - 1) {
            return true;
        }
        else {
            return false;
        }
    }
}
