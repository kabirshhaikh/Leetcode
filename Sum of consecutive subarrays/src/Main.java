public class Main {
    private static final int MOD = 1000000007;

    public static void main (String[] args) {
        int[] nums = {1,2,3};
        int test = getSum(nums);
        System.out.println(test);
    }


    private static int getSum (int[] nums) {
        int n = nums.length, mod = 1_000_000_007;
        long len = 0, sum = 0, res = 0;

        for(int i = 0; i < n; i++) {
            if(i > 0 && Math.abs(nums[i] - nums[i-1]) == 1) {
                len++;
                sum = (sum + len * nums[i]) % mod;
                res = (res + sum) % mod;

                if(i < n-1 && nums[i+1] - nums[i] == nums[i-1] - nums[i]) {
                    sum = nums[i];
                    len = 1;
                }
            } else {
                sum = nums[i];
                len = 1;
                res = (res + sum) % mod;
            }
        }
        return (int)res;
    }
}
