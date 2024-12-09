import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {4,3,1,6};
        int[][] queries = {{0,2}, {2,3}};
        boolean[] test = isArraySpecial(nums, queries);
        System.out.println(Arrays.toString(test));
    }


    public static boolean[] isArraySpecial (int[] nums, int[][] queries) {
        int n = nums.length;
        boolean[] test = new boolean[queries.length];

        int[] transitions = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            if ((nums[i] % 2 == 0 && nums[i + 1] % 2 == 0) || (nums[i] % 2 == 1 && nums[i + 1] % 2 == 1)) {
                transitions[i] = 1;
            } else {
                transitions[i] = 0;
            }
        }

        int[] prefix = new int[n];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (i - 1 < transitions.length ? transitions[i - 1] : 0);
        }

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            if (prefix[end] - prefix[start] > 0) {
                test[i] = false;
            } else {
                test[i] = true;
            }
        }

        return test;
    }

}