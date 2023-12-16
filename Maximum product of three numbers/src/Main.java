import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {-1,-2,-3};
        int test = maximumProduct(nums);
        System.out.println(test);
    }


    public static int maximumProduct (int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}