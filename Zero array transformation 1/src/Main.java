public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1};
        int[][] queries = {{0, 2}};
        boolean test = isZeroArray(nums, queries);
        System.out.println(test);
    }


    private static boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int[] q : queries) {
            int li = q[0], ri = q[1];
            diff[li]--;
            diff[ri + 1]++;
        }

        int currentDecrement = 0;

        for (int i = 0; i < n; i++) {
            currentDecrement += diff[i];
            if (nums[i] + currentDecrement > 0) {
                return false;
            }
        }
        return true;
    }
}
