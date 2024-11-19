public class Main {
    public static void main (String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int test = longestOnes(nums, k);
        System.out.println(test);
    }

    public static int longestOnes (int[] nums, int k) {
        int output = 0;
        int zeroCount = 0;
       int left = 0;

       for (int right = 0; right<nums.length; right++) {
           if (nums[right] == 0) {
               zeroCount++;
           }
           while (zeroCount > k) {
               if (nums[left] == 0) {
                   zeroCount--;
               }
               left = left + 1;
           }
           output = Math.max(output, right - left + 1);
       }

        return output;
    }
}
