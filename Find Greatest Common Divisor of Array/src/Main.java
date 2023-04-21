public class Main {
    public static void main (String[] args) {
        int[] nums = {7,5,6,8,3};
        findGCD(nums);
    }

    public static int findGCD (int[] nums) {
        int minValue = nums[0];
        int maxValue = nums[0];
        //Find Smallest Number:
        for (int i=0; i<nums.length; i++) {
           if (nums[i] < minValue ) {
               minValue = nums[i];
           }
        }
        //Find Largest Number:
        for (int i=0; i<nums.length; i++) {
           if (nums[i] > maxValue) {
               maxValue = nums[i];
           }
        }

        while (minValue != 0) {
            int temp = minValue;
            minValue = maxValue % minValue;
            maxValue = temp;
        }

        System.out.println("GCD:" +maxValue);

        return maxValue;
    }


}