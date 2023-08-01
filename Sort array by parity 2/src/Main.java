import java.util.Arrays;

public class Main {
    public static void  main (String[] args) {
        int[] nums = {4,2,5,7};
        sortArrayByParity2(nums);
    }

    public static int[] sortArrayByParity2 (int[] nums) {
        int evenIndex = 0;
        int oddIndex = 1;

        while (evenIndex < nums.length && oddIndex < nums.length) {
            while (evenIndex < nums.length && nums[evenIndex] % 2 == 0) {
                evenIndex += 2; // Move to the next even index
            }

            while (oddIndex < nums.length && nums[oddIndex] % 2 == 1) {
                oddIndex += 2; // Move to the next odd index
            }

            if (evenIndex < nums.length && oddIndex < nums.length) {
                // Swap the elements
                int temp = nums[evenIndex];
                nums[evenIndex] = nums[oddIndex];
                nums[oddIndex] = temp;
            }
        }

        System.out.println(Arrays.toString(nums));
        return nums;
    }


}