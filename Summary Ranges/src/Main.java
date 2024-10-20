import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int[] nums = {0,1,2,4,5,7};
        summaryRanges(nums);

    }


    public static List<String> summaryRanges (int[] nums) {
        List<String> output = new ArrayList<>();

        if (nums.length == 0) {
            return output;
        }

        int start = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    output.add(String.valueOf(start));
                } else {
                    output.add(start + "->" + nums[i - 1]);
                }
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }

        return output;
    }

}