import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3};
        int left = 2;
        int right = 3;
        int test = numSubarrayBoundedMax(nums, left, right);
        System.out.println(test);
    }

    public static int numSubarrayBoundedMax (int[] nums, int left, int right) {
        int count = 0;
        int start = -1; // track the starting index of the current subarray
        int lastValidMaxIndex = -1; // track the last index where the maximum is within [left, right]

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                lastValidMaxIndex = i;
            }

            if (nums[i] > right) {
                start = i;
                lastValidMaxIndex = i;
            }

            count += (lastValidMaxIndex - start);
        }

        return count;
    }
}