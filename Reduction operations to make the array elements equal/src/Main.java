import java.util.Arrays;

public class Main {
    public static void main (String[] tes) {
        int[] nums = {5,1,3};
        int test = reductionOperations(nums);
        System.out.println(test);
    }

    public static int reductionOperations (int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int up = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                up++;
            }

            ans += up;
        }

        return ans;
    }
}
