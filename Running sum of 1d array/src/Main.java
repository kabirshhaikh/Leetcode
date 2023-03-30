import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] array = {1,2,3,4};
        runningSum(array);
    }

    public static int[] runningSum (int[] nums) {
        int[] result = new int[nums.length];
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            count += nums[i];
            result[i] = count;
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}