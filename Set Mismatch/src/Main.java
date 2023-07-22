import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,2,4};
        int[] test = findErrorNums(nums);
        System.out.println(Arrays.toString(test));
    }


    public static int[] findErrorNums (int[] nums) {
        int n = nums.length;
        boolean[] present = new boolean[n + 1];
        int duplicated = -1;
        int missing = -1;

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (present[num]) {
                duplicated = num;
            } else {
                present[num] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                missing = i;
                break;
            }
        }

        return new int[]{duplicated, missing};
    }

}