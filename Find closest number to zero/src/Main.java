import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[] nums = {2, -1, 1};
        int test = findClosestNumber(nums);
        System.out.println(test );
    }


    public static int findClosestNumber (int[] nums) {
        HashMap<Integer, Integer> myMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            int distanceFromZero = Math.abs(currentNumber - 0);
            myMap.put(currentNumber, distanceFromZero);
        }

        int closestNumber = Integer.MAX_VALUE;
        int closestKey = 0;
        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int key = map.getKey();
            int value = map.getValue();
            if (value < closestNumber || (value == closestNumber && key > closestKey)) {
                closestNumber = value;
                closestKey = key;
            }
        }

        return closestKey;
    }
}
