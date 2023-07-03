public class Main {
    public static void main (String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1};
        int target = 11;
        int ans = minSubArrayLen(target, nums);
        System.out.println("Answer: " +ans);
    }

    public static int minSubArrayLen (int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for (int right=0; right<nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return  0;
        }
        else {
            return minLength;
        }

    }

}