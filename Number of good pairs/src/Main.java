public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,3,1,1,3};
        numIndenticalPairs(nums);

    }

    public static int numIndenticalPairs (int[] nums) {
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<nums.length; j++) {
                if (nums[i] == nums[j] && i!=j) {
                    count = count + 1;
                }
            }
        }
        int finalOuput = count/2;
        System.out.println("Output: " +finalOuput);
        return finalOuput;
    }
}