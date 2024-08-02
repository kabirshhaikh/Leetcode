public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,3,4};
        int test = minimumOperations(nums);
        System.out.println(test);
    }

    public static int minimumOperations (int[] nums) {
        int operations = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];

            // Check if the number is already divisible by 3
            if (currentNumber % 3 == 0) {
                continue;
            }

            // Check the minimal operations needed to make it divisible by 3
            int addOp = (currentNumber + 1) % 3 == 0 ? 1 : 2;
            int subOp = (currentNumber - 1) % 3 == 0 ? 1 : 2;
            operations += Math.min(addOp, subOp);
        }

        return operations;
    }

}
