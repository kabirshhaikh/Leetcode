public class Main {
    public static void main (String[] args) {
        int[] nums = {1,7,3,6,5,6};
        int test = pivotIndex(nums);
        System.out.println(test);
    }


    public static int pivotIndex (int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }


            for (int k = i + 1; k < nums.length; k++) {
                rightSum += nums[k];
            }


            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }
}