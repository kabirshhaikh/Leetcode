import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {6,6,5,6,3,8};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int current = nums[i];
            int next = nums[i + 1];
            if (i % 2 == 0 && current > next) {
                nums[i] = next;
                nums[i + 1] = current;
            } else if (i % 2 == 1 && current < next) {
                nums[i] = next;
                nums[i + 1] = current;
            }
        }
    }
}
