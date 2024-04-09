public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 11, 10, 1, 3};
        int k = 10;
        int test = minOperations(nums, k);
        System.out.println(test);
    }


    public static int minOperations(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < k)
                ++count;
        }
        return count;
    }
}