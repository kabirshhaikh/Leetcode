public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,3,4};
        int test = numberOfArithmeticSlices(nums);
        System.out.println(test);
    }



    public static int numberOfArithmeticSlices (int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int count = 0;
        int currentLength = 0;

        for (int i=2; i<nums.length; i++) {
            if ((nums[i] - nums[i - 1]) == nums[i-1] - nums[i-2]) {
                currentLength++;
                count = count+currentLength;
            }
            else {
                currentLength = 0;
            }
        }


        return count;
    }
}