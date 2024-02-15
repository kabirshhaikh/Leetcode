public class Main {
    public static void main (String[] args) {
        int[] nums = {8,6,1,5,3};
        int test = minimumSum(nums);
        System.out.println(test);
    }

    public static int minimumSum (int[] nums) {
        int miniSum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[j] && nums[j] > nums[k]) {
                        int currentSum = nums[i] + nums[j] + nums[k];
                        miniSum = Math.min(miniSum, currentSum);
                    }
                }
            }
        }

        return miniSum == Integer.MAX_VALUE ? -1 : miniSum;
    }
}