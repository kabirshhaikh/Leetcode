import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {6,5,4,8};
        smallerNumberThanCurrent(nums);
    }

    public static int[] smallerNumberThanCurrent (int[] nums) {
        int[] result = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            int count = 0;
            for (int j=0; j<nums.length ; j++) {
                if (nums[i] > nums[j] && i!=j ) {
                    count++;
                }
            }
            result[i] = count;
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

}