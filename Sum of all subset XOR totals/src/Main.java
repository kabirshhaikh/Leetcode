public class Main {
    public static void main (String[] args) {
        int[] nums = {1,3};
        int test = subsetXORSum(nums);
        System.out.println(test);
    }


    public static int subsetXORSum (int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < (1 << n); i++) {
            int xor = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    xor ^= nums[j];
                }
            }
            sum += xor;
        }

        return sum;
    }
}