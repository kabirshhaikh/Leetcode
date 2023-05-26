public class Main {
    public static void main (String[] args) {
        int[] nums = {0,1,1,3,3,};
        int k = 4;
        findMaxAverage(nums, k);
    }

    public static double findMaxAverage (int[] nums, int k) {
        double maximumAverage = Double.NEGATIVE_INFINITY;
        double currentAverage = 0;
        for (int i=0; i<k; i++) {
            int currentNumber = nums[i];
            currentAverage += currentNumber;
        }
        maximumAverage = currentAverage/k;
        for (int i=k; i<nums.length;i++) {
            currentAverage -= nums[i-k];
            currentAverage += nums[i];
            double output = currentAverage/k;
            maximumAverage = Math.max(maximumAverage, output);
        }
        System.out.println("Maximum average:" + maximumAverage);
        return maximumAverage;
    }

}