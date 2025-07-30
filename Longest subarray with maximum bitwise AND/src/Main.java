public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 2, 2};
        int test = longestSubArray(nums);
        System.out.println(test);
    }

    public static int longestSubArray(int[] nums) {
        int max = -1;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }

        int current = 0;
        int longest = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                current++;
                longest = Math.max(longest, current);
            } else {
                current = 0;
            }
        }

        return longest;
    }

}
