import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,5,2,3};
        int target = 2;
        targetIndices(nums, target);
    }

    public static List<Integer> targetIndices (int[] nums, int target) {
        List<Integer> myList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums[i];
            if (currentNumber == target) {
                myList.add(i);
            }
        }
        return myList;
    }
}