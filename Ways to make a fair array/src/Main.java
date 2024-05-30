public class Main {
    public static void main (String[] args) {
        int[] nums = {1,1,1};
        int test = waysToMakeFair(nums);
        System.out.println(test);
    }


    public static int waysToMakeFair (int[] nums) {
        int n = nums.length;
        int totalEvenSum = 0, totalOddSum = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                totalEvenSum += nums[i];
            } else {
                totalOddSum += nums[i];
            }
        }

        int leftEvenSum = 0, leftOddSum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                totalEvenSum -= nums[i];
            } else {
                totalOddSum -= nums[i];
            }

            if (leftEvenSum + totalOddSum == leftOddSum + totalEvenSum) {
                count++;
            }

            if (i % 2 == 0) {
                leftEvenSum += nums[i];
            } else {
                leftOddSum += nums[i];
            }
        }

        return count;
    }
}
