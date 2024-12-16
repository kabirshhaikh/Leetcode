import java.util.Arrays;


public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2};
        int k = 3;
        int multiplier = 4;
        int[] test = getFinalState(nums, k, multiplier);
        System.out.println(Arrays.toString(test));
    }



    public static int[] getFinalState (int[] nums, int k, int multiplier) {
       int counter = 0;

       while (counter < k) {
           int[] arr = returnNumberAndIndex(nums);
           int smallestNumber = arr[0];
           int indexOfNumber = arr[1];

           nums[indexOfNumber] = smallestNumber * multiplier;

           counter++;
       }

        return nums;
    }

    public static int[] returnNumberAndIndex (int[] nums) {
        int smallestNumber = Integer.MAX_VALUE;
        int indexOfSmallestNumber = 0;
        int[] output = new int[2];

        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums[i];
            int index = i;
            if (currentNumber < smallestNumber) {
                smallestNumber = currentNumber;
                indexOfSmallestNumber = index;
            }
        }

        output[0] = smallestNumber;
        output[1] = indexOfSmallestNumber;
        return output;
    }
}

