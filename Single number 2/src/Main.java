import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[] nums = {0,1,0,1,0,1,99};
        int test = singleNumber(nums);
        System.out.println(test);
    }



    public static int singleNumber (int[] nums) {
        HashMap<Integer, Integer> myList = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            myList.put(nums[i], myList.getOrDefault(nums[i], 0) + 1);
        }

        int output = 0;

        for (Map.Entry<Integer, Integer> map : myList.entrySet()) {
            int key = map.getKey();
            int count = map.getValue();

            if (count == 1) {
                output = key;
            }

        }

        return output;
    }
}