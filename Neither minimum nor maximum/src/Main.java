import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2};
        int test = findNonMinOrMax(nums);
        System.out.println(test);
    }

    public static int findNonMinOrMax (int[] nums) {
        Arrays.sort(nums);
        int output = -1;
        if (nums.length <= 2) {
            return -1;
        }
        output = nums[1];
        return output;
    }
}