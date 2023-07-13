import java.util.*;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,-1,1,-1,1,-1,1};
        boolean test = findSubarrays(nums);
        System.out.println(test);
    }

    public static boolean findSubarrays (int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        HashSet<Integer> mySet = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if (i < nums.length - 1 && !mySet.add(nums[i] + nums[i+1])) {
                return true;

            }
        }
        return false;
    }

}
