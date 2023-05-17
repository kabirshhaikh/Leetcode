public class Main {
    public static void main (String[] args) {
        int[] nums = {9,72,34,29,-49,-22,-77,-17,-66,-75,-44,-30,-24};
        arraySign(nums);
    }

    public static int arraySign (int[] nums) {
        double product = 1;
        for (int i=0; i<nums.length;i++) {
            product *= nums[i];
        }
        System.out.println("Product : " +product);

        if (product > 0) {
            return 1;
        }
        else if (product < 0) {
            return -1;
        }
        else {
            return 0;
        }

    }



}