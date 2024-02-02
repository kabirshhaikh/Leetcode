import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,1};
        int[] test = nextGreaterElements(nums);
        System.out.println(Arrays.toString(test));
    }


    public static int[] nextGreaterElements (int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        Arrays.fill(output, -1);

        for (int i = 0; i < n; i++) {
            int currentNumber = nums[i];
            for (int j = i + 1; j < i + n; j++) {
                int nextIndex = j % n;
                if (currentNumber < nums[nextIndex]) {
                    output[i] = nums[nextIndex];
                    break;
                }
            }
        }

        return output;
    }
}