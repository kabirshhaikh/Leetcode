import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,10,5,7};
        boolean test = canBeIncreasing(nums);
        System.out.println(test);
    }


    public static boolean canBeIncreasing (int[] nums) {
        final int n = nums.length;
        int i;

        for (i = 0; i < n - 1; ++i) {
            if (nums[i] >= nums[i + 1]) {
                break;
            }
        }
        if (i == n - 1) {
            return true;
        }

        if ((i == 0 || nums[i - 1] < nums[i + 1]) && isIncreasing(nums, i + 1)) {
            return true;
        }
        if ((i + 1 == n - 1 || nums[i] < nums[i + 2]) && isIncreasing(nums, i + 2)) {
            return true;
        }
        return false;
    }

    private static boolean isIncreasing(int[] nums, int start) {
        for (int i = start; i < nums.length - 1; ++i) {
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}