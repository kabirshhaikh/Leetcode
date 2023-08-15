import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
    }

    public static void rotate (int[] nums, int k ) {
        int left = 0;
        int right = nums.length -k;
        while (left < k && right<nums.length ) {
            int leftNumber = nums[left];
            int rightNumber = nums[right];
            int temp = rightNumber;
            nums[right] = leftNumber;
            nums[left] = temp;
            left++;
            right++;
        }
        System.out.println(Arrays.toString(nums));
    }

}