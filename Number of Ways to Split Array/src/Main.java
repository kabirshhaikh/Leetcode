import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {10,4,-8,7};
        waysToSplitArray(nums);
    }

    public static int waysToSplitArray (int[] nums) {
        int validSplit = 0;
        long[] prefix = new long[nums.length];
        prefix[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        for (int k=0; k<prefix.length-1; k++) {
            long currentSum = prefix[k];
            long remainingNumbers = prefix[prefix.length-1] - prefix[k];
            if (currentSum >= remainingNumbers) {
                validSplit = validSplit + 1;
            }
        }
        return validSplit;
    }
}