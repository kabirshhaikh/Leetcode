import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,3,4,3,2,5};
        int k = 3;
        int[] test = resultsArray(nums, k);
        System.out.println(Arrays.toString(test));
    }


    public static int[] resultsArray (int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[length - k + 1];

        for (int start = 0; start <= length - k; start++) {
            boolean isConsecutiveAndSorted = true;

            // Check if the current subarray is sorted and consecutive
            for (int index = start; index < start + k - 1; index++) {
                if (nums[index + 1] != nums[index] + 1) {
                    isConsecutiveAndSorted = false;
                    break;
                }
            }

            // If valid, take the maximum of the subarray, otherwise set to -1
            if (isConsecutiveAndSorted) {
                // Maximum element of this subarray
                result[start] = nums[start + k - 1];
            } else {
                result[start] = -1;
            }
        }

        return result;
    }
}
