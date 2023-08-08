import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
    }
    
    
    public static void sortColors (int[] nums) {
        for (int left = 0; left < nums.length - 1; left++) {
            for (int right = left + 1; right < nums.length; right++) {
                int leftNumber = nums[left];
                int rightNumber = nums[right];
                if (leftNumber > rightNumber) {
                    int temp = rightNumber;
                    nums[right] = leftNumber;
                    nums[left] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    
}
