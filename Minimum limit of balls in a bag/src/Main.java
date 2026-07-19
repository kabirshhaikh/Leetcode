public class Main {
    public static void main(String[] args) {
        int[] nums = {9};
        int maxOperations = 2;
        int ans = minimumSize(nums, maxOperations);
        System.out.println(ans);
    }

    public static int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = maximumElementInNums(nums);

        while (low < high) {
            int mid = low + (high - low) / 2;
            boolean isPossible = possible(nums, mid, maxOperations);
            if (isPossible) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }

    public static boolean possible(int[] nums, int maxBalls, int maxOperations) {
        int totalSplits = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSplits += (int) Math.ceil((double) nums[i] / maxBalls) - 1;
        }

        return totalSplits <= maxOperations;
    }

    public static int maximumElementInNums(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        return max;
    }
}
