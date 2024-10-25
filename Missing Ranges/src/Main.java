import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int[] nums = {0,1,3,50,75};
        int lower = 0;
        int upper = 99;
        findMissingRanges(nums, lower, upper);
    }


    public static List<List<Integer>> findMissingRanges (int[] nums, int lower, int upper) {
        List<List<Integer>> output = new ArrayList<>();
        int numsIndex = 0;
        int i = lower;

        while (i <= upper) {
            int numsElement = (numsIndex < nums.length) ? nums[numsIndex] : upper + 1;

            if (i < numsElement) {
                int leftRange = i;
                int rightRange = numsElement - 1;

                if (leftRange <= rightRange) {
                    List<Integer> range = new ArrayList<>();
                    range.add(leftRange);
                    range.add(rightRange);
                    output.add(range);
                }
                i = numsElement;
            } else if (i == numsElement) {
                i++;
                numsIndex++;
            } else {
                // This case handles when i > numsElement due to previous increments
                numsIndex++;
            }
        }


        return output;
    }
}
