import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {9,4,1,7};
        int k = 2;
        int test = minimumDifference(nums, k);
        System.out.println(test);
    }


    public static int minimumDifference (int[] nums, int k) {
        if (nums.length == 0 || k == 1) {
            return 0;
        }

        Arrays.sort(nums);

        int minDifference = Integer.MAX_VALUE;

        for (int i = 0; i <= nums.length - k; i++) {
            int difference = nums[i + k - 1] - nums[i];
            if (difference < minDifference) {
                minDifference = difference;
            }
        }

        return minDifference;
    }
}
