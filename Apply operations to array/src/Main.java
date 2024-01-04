import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,2,1,1,0};
        int[] test = applyOperations(nums);
        System.out.println(Arrays.toString(test));
    }


    public static int[] applyOperations (int[] nums) {
        int i = 0;

        while (i < nums.length - 1) {
            int currentNumber = nums[i];
            int nextNumber = nums[i+1];

            if (currentNumber == nextNumber) {
                nums[i] = nums[i] * 2;
                nums[i+1] = 0;
            }

            i = i+1;
        }

       int nonZeroIndex = 0;
        for (int j=0; j<nums.length; j++) {
            if (nums[j] != 0) {
                nums[nonZeroIndex] = nums[j];
                nonZeroIndex = nonZeroIndex + 1;
            }
        }

        for (int j=nonZeroIndex; j<nums.length; j++) {
            nums[j] = 0;
        }

        return nums;
    }
}