import java.util.HashMap;

public class Main {
    public static void main (String[] args) {
        int[] nums = {18,43,36,13,7};
        int test = maximumSum(nums);
        System.out.println(test);
    }

    private static int maximumSum (int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        HashMap<Integer, Integer> myMap = new HashMap<>();

        //Update the maxSum:
        for (int i=0; i<nums.length; i++) {
            int digitSum = returnSum(nums[i]);
            if (!myMap.containsKey(digitSum)) {
                myMap.put(digitSum, nums[i]);
            }
            else {
                int previousNumberWithSameDigitSum = myMap.get(digitSum);
                int sumOfPreviousNumberAndCurrentNumberWithSameDigitSum = nums[i] + previousNumberWithSameDigitSum;
                maxSum = Math.max(maxSum, sumOfPreviousNumberAndCurrentNumberWithSameDigitSum);
                //update the key with greater value:
                myMap.put(digitSum, Math.max(previousNumberWithSameDigitSum, nums[i]));
            }
        }

        return maxSum == Integer.MIN_VALUE ? -1 : maxSum;
    }


    private static int bruteForceApproachMaximumSum (int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        for (int i=0; i<nums.length; i++) {
            int digitSum = returnSum(nums[i]);
            for (int j=i+1; j<nums.length; j++) {
                int nextDigitSum = returnSum(nums[j]);
                if (nextDigitSum == digitSum) {
                    maxSum = Math.max(maxSum, nums[i] + nums[j]);
                }
            }
        }

        if (maxSum == Integer.MIN_VALUE) {
            return -1;
        }
        else {
            return maxSum;
        }
    }


    private static int returnSum (int number) {
        String num = String.valueOf(number);
        char[] chars = num.toCharArray();
        int sum = 0;

        for (int i=0; i<chars.length; i++) {
            sum = sum + chars[i] - '0';
        }

        return sum;
    }
}
