import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {-3,3,3,90};
        int test = countElements(nums);
        System.out.println(test);
    }


    public static int countElements (int[] nums) {
        int output = 0;
        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums[i];
            boolean isGreater = false;
            boolean isSmaller = false;
            for (int j=0; j<nums.length; j++) {
                int currentNextNumber = nums[j];
                if (currentNextNumber != currentNumber && currentNextNumber > currentNumber) {
                    isGreater = true;
                }
                else if (currentNextNumber != currentNumber && currentNextNumber < currentNumber) {
                    isSmaller = true;
                }
            }
            if (isGreater && isSmaller) {
                output = output + 1;
            }
        }

        return output;
    }
}