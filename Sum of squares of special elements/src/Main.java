public class Main {
    public static void main (String[] args) {
        int[] nums = {2,7,1,19,18,3};
        int test = sumOfSquares(nums);
        System.out.println(test);
    }

    public static int sumOfSquares (int[] nums) {
        int output = 0;
        int n = nums.length;
        for (int i=1; i<=n; i++) {
            if (n % i == 0) {
                int square = nums[i-1] * nums[i-1];
                output += square;
            }
        }
        return output;
    }
}