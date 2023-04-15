public class Main {
    public static void main (String[] tst) {
        int[] nums = {3,4,5,2};
        maxProduct(nums);
    }

    public static int maxProduct (int[] nums) {
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int maxProduct = ((nums[i] - 1) * (nums[j] - 1));
                if (maxProduct > count) {
                    count = maxProduct;
                }
            }
        }
        System.out.println("Count:" +count);
        return count;
    }
}