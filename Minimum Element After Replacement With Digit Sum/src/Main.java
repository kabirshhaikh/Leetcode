import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {10, 12, 13, 14};
        int test = minElement(nums);
        System.out.println(test);
    }

    public static int minElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            String current = Integer.toString(nums[i]);
            int sum = 0;
            for (int j = 0; j < current.length(); j++) {
                sum = sum + Character.getNumericValue(current.charAt(j));
            }

            nums[i] = sum;
        }

        Arrays.sort(nums);

        return nums[0];
    }
}

