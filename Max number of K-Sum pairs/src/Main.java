import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int k = 6;
        int[] nums = {3,1,3,4,3};
        int test = maxOperations(nums, k);
        System.out.println(test);
    }


    public static int maxOperations (int[] nums, int k) {
        Arrays.sort(nums);
        int operation = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {

                operation = operation + 1;
                left = left + 1;
                right = right - 1;
            }
            else if (sum < k) {
                left = left + 1;
            }
            else {
                right = right - 1;
            }
        }

        return operation;
    }

}
