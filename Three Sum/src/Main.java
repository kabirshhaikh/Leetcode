import java.util.*;
import java.util.Set;


public class Main {
    public static void main (String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        threeSum(nums);
    }

    public static List<List<Integer>> threeSum (int[] nums) {
        List<List<Integer>> myList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=1; i<nums.length; i++) {
            if (nums[i] != nums[i-1] || i==1) {
                int left = i+1;
                int right = nums.length-1;
                while (left < right) {
                    int sum = nums[i] + nums[left] +nums[right];
                    if (sum == 0) {
                        myList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                       while (left < right && nums[left] == nums[left=1]) {
                           left = left + 1;
                       }
                       while (left < right && nums[right] == nums[right-1]) {
                           right = right - 1;
                       }
                    }
                    else if (sum < 0) {
                        left = left + 1;
                    }
                    else {
                        right = right - 1;
                    }
                }
            }
        }
        return myList;
    }
}