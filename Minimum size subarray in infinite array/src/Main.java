
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 1, 2, 1, 2, 1, 2, 1};
        int target = 83;
        int test = minSizeSubarray(nums, target);
        System.out.println(test);
    }

    public static int minSizeSubarray(int[] nums, int target) {
        long totalSum = returnTotalSum(nums);

        long fullCycles = target / totalSum;
        int remainingTarget = (int)(target % totalSum);

        if (remainingTarget == 0) {
            return (int)(fullCycles * nums.length);
        }

        int[] doubleNums = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            doubleNums[i] = nums[i];
            doubleNums[i + nums.length] = nums[i];
        }

        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < doubleNums.length; right++) {
            sum += doubleNums[right];

            while (sum > remainingTarget) {
                sum -= doubleNums[left];
                left++;
            }

            if (sum == remainingTarget) {
                minLength = Math.min(minLength, right - left + 1);
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return -1;
        }

        // Total length = (full cycles * nums.length) + minLength
        return (int)(fullCycles * nums.length) + minLength;
    }

    public static long returnTotalSum(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
