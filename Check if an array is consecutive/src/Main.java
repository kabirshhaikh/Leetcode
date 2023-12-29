import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,3};
        boolean test = isConsecutive(nums);
        System.out.println(test);
    }


    public static boolean isConsecutive (int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Arrays.sort(nums);
        int min = nums[0];
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (nums[i] != min + i) {
                return false;
            }
        }

        return true;
    }
}