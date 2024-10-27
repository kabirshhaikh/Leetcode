import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,2,3,1};
        int test = findShortestSubArray(nums);
        System.out.println(test);
    }


    public static int findShortestSubArray (int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int degree = Integer.MIN_VALUE;

        HashMap<Integer, Integer> degreeMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            degreeMap.put(nums[i], degreeMap.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> map : degreeMap.entrySet()) {
            int key = map.getKey();
            int count = map.getValue();
            if (count > degree) {
                degree = count;
            }
        }

        int right = 0;
        int left = 0;


        int minLength = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (right < nums.length) {

            int currentNumber = nums[right];

            map.put(currentNumber, map.getOrDefault(currentNumber, 0) + 1);

            while (map.get(currentNumber) == degree) {
                minLength = Math.min(minLength, right - left + 1);
                map.put(nums[left], map.get(nums[left]) - 1);
                left = left + 1;
            }

            right = right + 1;
        }

        return minLength;
    }
}
