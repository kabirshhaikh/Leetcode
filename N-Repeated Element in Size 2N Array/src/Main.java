import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[] nums = {2,1,2,5,3,2};
        int test = repeatedNTimes(nums);
        System.out.println(test);
    }

    public static int repeatedNTimes (int[] nums) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums[i];
            myMap.put(currentNumber, myMap.getOrDefault(currentNumber, 0) + 1);
        }
        int count = Integer.MIN_VALUE;
        int outputKey = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int value = map.getValue();
            int key = map.getKey();
            System.out.println("Key: "+key +", value: "+value);
            if (value > count) {
                count = value;
                outputKey = key;
            }
        }
        return outputKey;
    }


}
