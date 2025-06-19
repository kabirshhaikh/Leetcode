public class Main {
    public static void main(String[] args) {
        int[] nums = {3,2,5,4};
        int threshold = 5;
        int test = longestAlternatingSubarray(nums, threshold);
        System.out.println(test);

    }

    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int maxLen = 0;

        for (int l = 0; l < n; l++) {
            if (nums[l] % 2 != 0 || nums[l] > threshold) {
                continue;
            }

            int r = l;

            while (r < n && nums[r] <= threshold && (r == l || nums[r] % 2 != nums[r - 1] % 2)) {
                r++;
            }

            maxLen = Math.max(maxLen, r - l);
        }

        return maxLen;
    }
}
