public class Main {
    public static void main (String[] args) {
        int[] nums = {1,0,0,1,0,1};
        int k = 2;
        boolean test = kLengthApart(nums, k);
        System.out.println(test);
    }



    public static boolean kLengthApart (int[] nums, int k) {
        int count = k;
        for (int num : nums) {
            if (num == 1) {
                if (count < k) {
                    return false;
                }
                count = 0;
            } else {
                count++;
            }
        }
        return true;
    }
}