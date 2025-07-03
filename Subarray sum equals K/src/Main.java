import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        int test = subarraySum(nums, k);
        System.out.println(test);
    }

    public static int subarraySum(int[] nums, int k) {
        int output = 0;
        int currentSum = 0;

        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            // If (currentSum - k) has occurred before, it means a subarray ending here sums to k
            if (prefixSum.containsKey(currentSum - k)) {
                output += prefixSum.get(currentSum - k);
            }

            prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);
        }

        return output;
    }

}
