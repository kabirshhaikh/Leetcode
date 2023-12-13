import java.util.Arrays;

public class Main {
    public static void  main (String[] args) {
        int[] nums = {5,1,4,1};
        int indexDifference = 2;
        int valueDifference = 4;
        int[] test = findIndices(nums, indexDifference, valueDifference);
        System.out.println(Arrays.toString(test));
    }


    public static int[] findIndices (int[] nums, int indexDifference, int valueDifference) {
        int[] output = {-1, -1};

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + indexDifference; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    output[0] = i;
                    output[1] = j;
                    return output;
                }
            }
        }

        return output;
    }
}