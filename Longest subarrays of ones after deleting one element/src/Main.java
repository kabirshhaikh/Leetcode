public class Main {
    public static void main (String[] args) {
        int[] nums = {0,1,1,1,0,1,1,0,1};
        int test = longestSubarray(nums);
        System.out.println(test);
    }



    public static int longestSubarray (int[] nums) {
        int left = 0;
        int countZero = 0;
        int longestArray = 0;

        for (int right=0; right < nums.length; right++) {
            if (nums[right] == 0) {
                countZero = countZero + 1;
            }

            while (countZero > 1) {
                if (nums[left] == 0) {
                    countZero = countZero - 1;
                }
                left = left + 1;
            }

            longestArray = Math.max(longestArray, right - left);
        }


        return longestArray;
    }
}