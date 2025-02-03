public class Main {
    public static void main (String[] args) {
        int[] nums = {3,2,1};
        int test = longestMonotonicSubarray(nums);
        System.out.println(test);
    }


    private static int longestMonotonicSubarray (int[] nums) {
        int increasing = 1;
        int maxInc = 1;
        int decreasing = 1;
        int maxDec = 1;

        // Check strictly increasing:
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                increasing++;
            } else {
                maxInc = Math.max(maxInc, increasing);
                increasing = 1; // Reset count
            }
        }
        maxInc = Math.max(maxInc, increasing); // Ensure last sequence is counted

        // Check strictly decreasing:
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                decreasing++;
            } else {
                maxDec = Math.max(maxDec, decreasing);
                decreasing = 1; // Reset count
            }
        }
        maxDec = Math.max(maxDec, decreasing); // Ensure last sequence is counted

        return Math.max(maxInc, maxDec);
    }
}

