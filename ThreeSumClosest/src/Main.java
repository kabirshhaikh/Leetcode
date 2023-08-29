import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,1,1,0};
        int target = -100;
        int test = threeSumClosest(nums, target);
        System.out.println("Final Ouptut: " +test);
    }

    public static int threeSumClosest (int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closest = Integer.MAX_VALUE;
        int ans = 0;

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int gap = Math.abs(sum - target);

                if (gap < closest) {
                    closest = gap;
                    ans = sum;
                }

                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return ans;
    }
}