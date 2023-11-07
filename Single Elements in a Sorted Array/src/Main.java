import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        int test = singleNonDuplicate(nums);
        System.out.println(test);
    }


    public static int singleNonDuplicate (int[] nums) {
        HashMap<Integer, Integer> myMap = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums[i];
            myMap.put(currentNumber, myMap.getOrDefault(currentNumber, 0 ) + 1);
        }

        int output = 0;
        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int key = map.getKey();
            int count = map.getValue();
            if (count == 1) {
                output = key;
            }
        }
        return output;
    }

}