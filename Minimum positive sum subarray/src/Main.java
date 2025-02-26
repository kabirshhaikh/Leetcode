import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(-2);
        nums.add(1);
        nums.add(4);
        int l = 2;
        int r = 3;
        int test = minimumSumSubarray(nums, l, r);
        System.out.println(test);
    }

    //[3, -2, 1, 4]
    //l=2, r=3


    private static int minimumSumSubarray (List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int k = l; k <= r; k++) {
                if (i + k > n) break;
                int sum = prefix[i + k] - prefix[i];
                if (sum > 0 && sum < minSum) {
                    minSum = sum;
                }
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
