import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] test = singleNumber(nums);
        System.out.println(Arrays.toString(test));
    }

    public static int[] singleNumber(int[] nums) {
        int[] output = new int[2];
        HashMap<Integer, Integer> myMap = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums[i];
            myMap.put(currentNumber, myMap.getOrDefault(currentNumber, 0) + 1);
        }

        int index = 0;

        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int key = map.getKey();
            int count = map.getValue();
            if (count == 1) {
                output[index] = key;
                index = index + 1;
            }
        }

        return output;
    }

}