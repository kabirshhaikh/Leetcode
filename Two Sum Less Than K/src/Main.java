public class Main {
    public static void main (String[] args) {
        int[] nums = {34,23,1,24,75,33,54,8};
        int k = 60;
        sumLessThanK(nums, k);
    }

    public static int sumLessThanK (int[] nums, int k) {
        int maxSum = -1;
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                int currentSum = nums[i] + nums[j];
                if (currentSum < k && currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }

        System.out.println("Output:" +maxSum);
        if (maxSum != -1) {
            return maxSum;
        }
        else {
            return -1;
        }
    }
}