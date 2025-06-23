import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3, 3};
        int k = 2;
        long test = countSubarrays(nums, k);
        System.out.println(test);
    }


    public static long countSubarrays(int[] nums, int k) {
        int maxNumber = returnMaxNumber(nums);
        int left = 0;
        long output = 0;
        int maxElementInWindow = 0;

        for (int right = 0; right < nums.length; right++) {
           if (nums[right] == maxNumber) {
               maxElementInWindow++;
           }

           while (maxElementInWindow == k) {
               if (nums[left] == maxNumber) {
                   maxElementInWindow--;
               }
               left++;
           }

           output += left;
        }

        return output;
    }

    public static int returnMaxNumber(int[] nums) {
        int maxNumber = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNumber) {
                maxNumber = nums[i];
            }
        }

        return maxNumber;
    }
}
