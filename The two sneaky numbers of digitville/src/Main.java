import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] nums = {7,1,5,4,3,4,6,0,9,5,8,2};
        int[] test = getSneakyNumbers(nums);
        System.out.println(Arrays.toString(test));
    }

    public static int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        int[] output = new int[2];

        for (int i = 0; i < nums.length; i++) {
            myMap.put(nums[i], myMap.getOrDefault(nums[i], 0) + 1);
        }

        int index = 0;

        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int key = map.getKey();
            int val = map.getValue();
            if (val > 1) {
                output[index] = key;
                index++;
            }
        }

        return output;
    }
}
