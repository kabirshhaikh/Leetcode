import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {-4,-2,2,4};
        int a = 1;
        int b = 3;
        int c = 5;
        int[] test = sortTransformedArray(nums, a, b, c);
        System.out.println(Arrays.toString(test));
    }

    public static int[] sortTransformedArray (int[] nums, int a, int b, int c) {
        int[] output = new int[nums.length];
        for (int i=0; i< nums.length; i++) {
            int currentNumber = nums[i];
            int transformedNumber = a * currentNumber*currentNumber + b * currentNumber + c;
            output[i] = transformedNumber;
        }
        Arrays.sort(output);
        return output;
    }

}