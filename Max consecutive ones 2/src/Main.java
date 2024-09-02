public class Main {
    public static void main (String[] args) {
        int[] nums = {1,0,1,1,0,1};
        int test = findMaxConsecutiveOnes(nums);
        System.out.println(test);
    }




    public static int findMaxConsecutiveOnes (int[] nums) {
        int start = 0;
        int zeros = 0;
        int maxNumberOfOnes = Integer.MIN_VALUE;

        for (int end = 0; end<nums.length; end++) {
            if (nums[end] == 0) {
                zeros = zeros + 1;
            }
            while (zeros > 1) {
               if (nums[start] == 0) {
                   zeros = zeros - 1;
               }
               start = start + 1;
            }
            maxNumberOfOnes  = Math.max(maxNumberOfOnes, end - start + 1);
        }

        return maxNumberOfOnes;
    }

}