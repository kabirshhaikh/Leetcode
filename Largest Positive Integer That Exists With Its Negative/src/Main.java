import java.util.Arrays;

public class Main {
    public static void  main (String[] args) {
        int[] nums = {-10,8,6,7,-2,-3};
        int test = findMaxK(nums);
        System.out.println(test);
    }

    public static int findMaxK (int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int left=0;
        int right = nums.length-1;
        int output = Integer.MIN_VALUE;
        while (left <= right) {
            int leftNumber = nums[left];
            int rightNumber = nums[right];
            if (leftNumber == -rightNumber) {
                output = Math.max(output, rightNumber);
                break;
            }
            else if (leftNumber > -rightNumber) {
                right--;
            }
            else {
                left++;
            }
        }
        if (output == Integer.MIN_VALUE) {
            return -1;
        }
        else {
            return output;
        }
    }

}