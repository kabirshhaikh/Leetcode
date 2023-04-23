import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,3,4};
        decompressRLElist(nums);
    }

    public static int[] decompressRLElist (int[] nums) {
        ArrayList<Integer> myList = new ArrayList<>();
       for (int i=0; i<nums.length; i+=2) {
           //Store the frequency:
           int frequency = nums[i];
           //Store the value:
           int value = nums[i+1];
           for (int k=0; k<frequency; k++) {
               myList.add(value);
           }
       }
       int[] output = new int[myList.size()];
       for (int i=0; i<myList.size(); i++) {
          output[i] = myList.get(i);
       }
        System.out.println(Arrays.toString(output));
        return output;
    }


}