public class Main {
    public static void main (String[] args) {
        int[] nums = {4,3,1,6};
        boolean test = isArraySpecial(nums);
        System.out.println(test);
    }


    public static boolean isArraySpecial (int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        for (int i=1; i<nums.length; i++) {
            int currentNumber = nums[i];
            int previousNumber = nums[i-1];

            if (currentNumber % 2 == 0 && previousNumber % 2 == 0 || currentNumber % 2 != 0 && previousNumber % 2 != 0 ) {
                return false;
            }
        }

        return true;
    }
}
