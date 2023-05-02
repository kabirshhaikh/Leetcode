import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,1,1};
        minOperations(nums);
    }


    public static int minOperations (int[] nums) {
        int result = 0;
            for (int i=1; i<nums.length; i++) {
                if (nums[i] <= nums[i-1]) {
                    int difference = nums[i-1] - nums[i] + 1;
                    result = result + difference;
                    nums[i] = nums[i] + difference;
                }
            }
        System.out.println(Arrays.toString(nums));
        System.out.println("Result:" +result);
        return result;
    }

}
