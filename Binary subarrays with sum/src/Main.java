public class Main {
    public static void main (String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;
        int test = numSubArraysWithSum(nums, goal);
        System.out.println(test);
    }


    public static int numSubArraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    public static int atMost (int[] nums, int goal) {
        if (goal < 0) return 0; // No subarray can have a negative sum

        int left = 0, sum = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // Shrink the window if the sum exceeds `goal`
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }

            // Add the number of subarrays ending at `right`
            count += right - left + 1;
        }

        return count;
    }
}
