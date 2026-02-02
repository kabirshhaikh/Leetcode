public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 12};
        int test = minimumCost(nums);
        System.out.println(test);
    }

    private static int minimumCost(int[] nums) {
        int first = nums[0];
        int second = nums[1];

        int minCost = Integer.MAX_VALUE;

        for (int i = 2; i < nums.length; i++) {
            int sum = first + second + nums[i];
            minCost = Math.min(minCost, sum);
            second = Math.min(second, nums[i]);
        }

        return minCost;
    }
}
