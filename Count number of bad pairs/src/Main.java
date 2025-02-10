import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,3,4,5};
        long test = countBadPairs(nums);
        System.out.println(test);
    }

    private static long countBadPairs (int[] nums) {
        long goodPairs = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int key = nums[i] - i;

            if (map.containsKey(key)) {
                goodPairs = goodPairs + map.get(key);
            }

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        long totalPairs = (long) nums.length * (nums.length - 1) / 2;

        return totalPairs - goodPairs;
    }

    private static long countBadPairsBruteForceApproach (int[] nums) {
        long output = 0;

        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                int indexCalculation = j-i;
                int numberCalculation = nums[j] - nums[i];
                if (i < j && indexCalculation != numberCalculation) {
                    output++;
                }
            }
        }

        return output;
    }
}
