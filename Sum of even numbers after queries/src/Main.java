import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,3,4};
        int[][] queries = {{1,0}, {-3,1}, {-4,0}, {2,3}};
        int[] test = sumEvenAfterQueries(nums, queries);
        System.out.println(Arrays.toString(test));
    }


    public static int[] sumEvenAfterQueries (int[] nums, int[][] queries) {
        int[] output = new int[queries.length];
        int evenSum = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                evenSum += num;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];

            if (nums[index] % 2 == 0) {
                evenSum -= nums[index];
            }

            nums[index] += val;

            if (nums[index] % 2 == 0) {
                evenSum += nums[index];
            }

            output[i] = evenSum;
        }

        return output;
    }
}