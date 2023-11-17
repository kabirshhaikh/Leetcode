import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {9,12,5,10,14,3,10};
        int pivot = 10;
        int[] test = pivotArray(nums, pivot);
        System.out.println(Arrays.toString(test));
    }


    public static int[] pivotArray (int[] nums, int pivot) {
        ArrayList<Integer> lessThan = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> greaterThan = new ArrayList<>();


        for (int i=0; i<nums.length; i++) {
           if (nums[i] < pivot) {
               lessThan.add(nums[i]);
           }
           else if (nums[i] == pivot) {
               equal.add(nums[i]);
           }
           else {
               greaterThan.add(nums[i]);
           }
        }

        int[] output = new int[lessThan.size() + equal.size() + greaterThan.size()];
        int index = 0;

        for (int i=0; i< lessThan.size(); i++) {
            output[index] = lessThan.get(i);
            index = index + 1;
        }

        for (int i=0; i<equal.size(); i++) {
            output[index] = equal.get(i);
            index = index + 1;
        }

        for (int i=0; i< greaterThan.size(); i++) {
            output[index] = greaterThan.get(i);
            index = index + 1;
        }

        return output;
    }
}