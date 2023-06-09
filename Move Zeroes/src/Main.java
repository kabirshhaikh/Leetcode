import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {4,2,4,0,0,3,0,5,1,0};
        moveZeroes(nums);
    }


    public static void moveZeroes (int[] nums) {
        int index = 0;
        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums[i];
            if (currentNumber != 0) {
                nums[index] = currentNumber;
                index = index + 1;
            }
        }
        while (index < nums.length) {
            nums[index] = 0;
            index = index + 1;
        }
        System.out.println(Arrays.toString(nums));
    }

}