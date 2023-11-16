import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {0,0};
        int test = specialArray(nums);
        System.out.println(test);
    }

    public static int specialArray (int[] nums) {
        Arrays.sort(nums);
        for (int x = 0; x <= nums.length; x++) {
            int countGreaterThanOrEqualToX = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= x) {
                    countGreaterThanOrEqualToX++;
                }
            }

            if (countGreaterThanOrEqualToX == x) {
                return x;
            }
        }
        return -1;
    }
}