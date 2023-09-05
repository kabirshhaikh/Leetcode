import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,4,3,2};
        arrayPairSum(nums);
    }

    public static int arrayPairSum (int[] nums) {
        Arrays.sort(nums);
        int minimumSum = 0;
        for (int i=0; i<nums.length; i+=2) {
            int num1 = nums[i];
            int num2 = nums[i+1];
            int minimumNumber = Math.min(num1, num2);
            minimumSum = minimumSum + minimumNumber;
        }
        return minimumSum;
    }
}
