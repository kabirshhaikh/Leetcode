import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,7,9,2,5};
        int lower = 11;
        int upper = 11;
        long test = countFairPairs(nums, lower, upper);
        System.out.println(test);
    }


    public static long countFairPairs (int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long output = 0;

        for (int i=0; i<nums.length; i++) {
            int left = findLeft(nums, i + 1, lower - nums[i]);
            int right = findRight(nums, i + 1, upper - nums[i]);
            if (left <= right) {
                output += right - left + 1;
            }
        }
        return output;
    }


    public static int findLeft (int[] nums, int start, int target) {
        int left = start;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int findRight (int[] nums, int start, int target) {
        int left = start, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

}
