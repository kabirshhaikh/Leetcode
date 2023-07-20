import java.util.*;

public class Main {
    public static void main (String[] agrs) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        int test = missingNumber(nums);
        System.out.println(test);
    }

    public static int missingNumber (int[] nums) {
        int n = nums.length;
        int missingNumber = n;
        for (int i=0; i<n; i++) {
            missingNumber ^= i;
        }
        for (int i=0; i<nums.length; i++) {
            missingNumber ^= nums[i];
        }
        return missingNumber;
    }

}