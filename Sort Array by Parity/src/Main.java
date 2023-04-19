import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {3,1,2,4};
        sortArrayByParity(nums);
    }

    public static int[] sortArrayByParity (int[] nums) {
        ArrayList<Integer> myList = new ArrayList<>();

        //Add Even numbers to the arraylist:
        for (int i=0; i<nums.length; i++) {
            if (nums[i] % 2 == 0) {
                myList.add(nums[i]);
            }
        }

        //Add odd numbers to the array list:
        for (int i=0; i<nums.length; i++) {
            if (nums[i] % 2 == 1) {
                myList.add(nums[i]);
            }

        }

        //Iterator over the arraylist:
       int[] parityArray = new int[myList.size()];

        for ( int i=0; i< myList.size(); i++) {
            parityArray[i] = myList.get(i);
        }

        System.out.println(Arrays.toString(parityArray));

        return parityArray;
    }

}