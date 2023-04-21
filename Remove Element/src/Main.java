import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        removeElement(nums, val);
    }

    public static int removeElement (int[] nums, int val) {
        int count = 0;
        ArrayList<Integer> myList = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != val) {
                myList.add(nums[i]);
            }
        }
        for (int i=0; i< myList.size(); i++) {
            nums[i] = myList.get(i);
            count = count + 1;
        }
        System.out.println(Arrays.toString(nums));
        System.out.println("Count:" +count);
        return count;
    }
}