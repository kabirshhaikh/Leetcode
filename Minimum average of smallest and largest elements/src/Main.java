import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {7,8,3,4,15,13,4,1};
        double test = minimumAverage(nums);
        System.out.println(test);
    }


    public static double minimumAverage (int[] nums) {
        double[] average = new double[nums.length / 2];
        int index = 0;

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int minNumber = nums[left];
            int maxNumber = nums[right];

            average[index] = (minNumber + maxNumber) /2.0;
            index = index + 1;

            left = left + 1;
            right = right - 1;
        }

        Arrays.sort(average);

        return average[0];
    }
}
