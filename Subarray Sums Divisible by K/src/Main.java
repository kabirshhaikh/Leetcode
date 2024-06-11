import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] nums = {5};
        int k = 9;
        int test = subarraysDivByK(nums, k);
        System.out.println(test);
    }


    public static int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;
            int remainder = (sum % k + k) % k; // handle negative remainders
            count += prefixSumCount.getOrDefault(remainder, 0);
            prefixSumCount.put(remainder, prefixSumCount.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}
