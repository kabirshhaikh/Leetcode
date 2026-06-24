public class Main {
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        int test = splitArray(nums, k);
        System.out.println(test);
    }

    public static int splitArray(int[] nums, int k) {
        int low = maxElement(nums);
        int high = sumOfElements(nums);
        //low = 10, high = 32
        //mid = low + (high - low) / 2
        //mid = 10 + (32-10) / 2
        //mid = 10 + 22/2
        //mid = 21

        //space complexity: O(1) -> constant because we are not using any separate data structure to store data:
        //time complexity: O(nLog(s)) -> where s is sum of the elements from nums array

        while (low < high) {
            int mid = low + (high - low) / 2; //21 -> maximumAllowedSum
            boolean feasible = isFeasible(mid, nums, k);
            if (feasible) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static boolean isFeasible(int maxAllowedSum, int[] nums, int k) {
        int runningSum = 0;
        int subArrays = 1;

        for (int i = 0; i < nums.length; i++) {
            if (runningSum + nums[i] > maxAllowedSum) {
                subArrays++;
                runningSum = nums[i];
            } else {
                runningSum = runningSum + nums[i];
            }
        }

        return subArrays <= k;
    }

    public static int maxElement(int[] nums) {
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        return max;
    }

    public static int sumOfElements(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return sum;
    }
}
