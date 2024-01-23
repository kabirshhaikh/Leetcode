import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] test = searchRange(nums, target);
        System.out.println(Arrays.toString(test));
    }



    public static int[] searchRange (int[] nums, int target) {
        int[] output = new int[2];

        int number1 = firstPosition(nums, target);
        int number2 = lastPosition(nums, target);

        output[0] = number1;
        output[1] = number2;

        return output;
    }

    public static int firstPosition (int[] nums, int target) {
        int firstIndex = -1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == target) {
                firstIndex = i;
                break;
            }
        }
        return firstIndex;
    }

    public static int lastPosition (int[] nums, int target) {
        int lastIndex = -1;
        for (int i=nums.length - 1; i >= 0; i--) {
            int currentNumber = nums[i];
            if (currentNumber == target) {
                lastIndex = i;
                break;
            }
        }
        return lastIndex;
    }
}