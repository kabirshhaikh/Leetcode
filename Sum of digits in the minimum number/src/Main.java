import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {34,23,1,24,75,33,54,8};
        int test = sumOfDigits(nums);
        System.out.println(test);
    }

    public static int sumOfDigits (int[] nums) {
        int smallestNumber = Integer.MAX_VALUE;
        int output = 0;
        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums[i];
            if (currentNumber < smallestNumber) {
                smallestNumber = currentNumber;
            }
        }
        String number = String.valueOf(smallestNumber);
        char[] chars = number.toCharArray();
        for (int i=0; i< chars.length; i++) {
            char currentChar = chars[i];
            int value = currentChar - '0';
            output += value;
        }
        if (output % 2 == 1) {
            return 0;
        }else {
            return 1;
        }
    }
}