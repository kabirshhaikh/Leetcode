public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 3, 8, 48, 10};
        int test = longestNiceSubarray(nums);
        System.out.println(test);
    }


    private static int longestNiceSubarray(int[] nums) {
        int longestSubarray = 0;
        int bitmask = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while ((bitmask & nums[right]) != 0) {
                bitmask ^= nums[left];
                left++;
            }
            bitmask |= nums[right];
            longestSubarray = Math.max(longestSubarray, right - left + 1);
        }

        return longestSubarray;
    }
}
