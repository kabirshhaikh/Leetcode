public class Main {
    public static void main(String[] args) {
        int[] nums = {2,1,3};
        int k = 4;
        int test = kthSmallestSubarraySum(nums, k);
        System.out.println(test);
    }

    public static int kthSmallestSubarraySum(int[] nums, int k) {
        int low = getMin(nums);
        int high = getSum(nums);

        while (low < high) {
            int mid = (low + high) / 2;
            if (countSubarrays(nums, mid) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static int countSubarrays(int[] nums, int target) {
        int left = 0;
        int sum = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > target) {
                sum -= nums[left];
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public static int getSum(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return sum;
    }

    public static int getMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }

        return min;
    }
}
