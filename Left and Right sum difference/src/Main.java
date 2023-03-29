import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main (String[] arguments) {
        int[] result = {10,4,8,3};
        leftRightDifference(result);
    }

    public static int[] leftRightDifference (int[] nums) {
        int numsLength = nums.length;
        int[] answer = new int[nums.length];
        int[] prefixArray = new int[nums.length];
        int prefixSumCounter = 0;

        for (int i=0; i<nums.length; i++) {
            prefixSumCounter += nums[i];
            prefixArray[i] = prefixSumCounter;
        }

        int[] suffixArray = new int[nums.length];
        int suffixCounter = 0;

        for (int i=nums.length-1 ; i>=0; i--) {
            suffixCounter += nums[i];
            suffixArray[i] = suffixCounter;
        }

       for (int i=0; i<numsLength; i++) {
           answer[i] = Math.abs(prefixArray[i] - suffixArray[i]);
       }

        System.out.println("Answer Array :" + Arrays.toString((answer)));
        return answer;
    }

}