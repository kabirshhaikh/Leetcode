import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        int[] test = rearrangeArray(nums);
        System.out.println(Arrays.toString(test));
    }


    public static int[] rearrangeArray (int[] nums) {
        int[] positiveArray = new int[nums.length/2];
        int positiveIndex = 0;
        int[] negativeArray = new int[nums.length/2];
        int negativeIndex = 0;
        ArrayList<Integer> myList = new ArrayList<>();
        int[] output = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums[i];
            if (currentNumber > 0) {
                positiveArray[positiveIndex] = currentNumber;
                positiveIndex = positiveIndex + 1;
            }
            else {
                negativeArray[negativeIndex] = currentNumber;
                negativeIndex = negativeIndex + 1;
            }
        }
        int i = 0;
        int j = 0;
        while (i<positiveArray.length && j < negativeArray.length) {
           int positiveNum = positiveArray[i];
           int negativeNum = negativeArray[j];
           myList.add(positiveNum);
           myList.add(negativeNum);
           i++;
           j++;
        }
        for (int k=0; k< myList.size(); k++) {
            output[k] = myList.get(k);
        }
        return output;
    }

}
