public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        int test = longestOnes(nums, k);
        System.out.println(test);
    }


    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroCount = 0;
        int maxOnes = 0;


        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount = zeroCount + 1;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount = zeroCount - 1;
                }
                left = left + 1;
            }

            maxOnes = Math.max(maxOnes, right - left + 1);
        }


        return maxOnes;
    }
}
