import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] test = distinctDifferenceArray(nums);
        System.out.println(Arrays.toString(test));
    }

    public static int[] distinctDifferenceArray (int[] nums) {
        int[] arr = new int[nums.length];
        int index = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = 0;
            for(int j = 0; j <= i; j++) {
                set.add(nums[j]);
            }
            left = set.size();
            set.clear();

            for(int k = i+1; k < nums.length; k++) {
                set.add(nums[k]);
            }
            right = set.size();
            set.clear();
            arr[index++] = left - right;
        }
        return arr;
    }
}