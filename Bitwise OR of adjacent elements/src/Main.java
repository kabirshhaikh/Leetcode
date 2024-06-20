import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,3,7,15};
        int[] test = orArray(nums);
        System.out.println(Arrays.toString(test));
    }

    public static int[] orArray (int[] nums) {
        int[] answer = new int[nums.length - 1];

        for (int i=0; i<nums.length-1; i++) {
            int num1 = nums[i];
            int num2 = nums[i+1];

            int result = num1 | num2;
            answer[i] = result;
        }

        return answer;
    }
}
