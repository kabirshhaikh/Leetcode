import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {3,6,1,9};
        int test = maximumGap(nums);
        System.out.println(test);
    }


    public static int maximumGap (int[] nums) {
        int gap = 0;

        if (nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);

        for (int i=0; i<nums.length - 1; i++) {
            int currentGap = nums[i+1] - nums[i];
            if (currentGap > gap) {
                gap = currentGap;
            }
        }

        return gap;
    }
}