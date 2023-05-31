public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;
        containsNearByDuplicate(nums, k);

    }

    public static boolean containsNearByDuplicate (int[] nums, int k) {
        for (int i=0; i<nums.length; i++) {
            int j = Math.max(0, i-k);
            while (j<i) {
                if (nums[i] == nums[j] && Math.abs(i-j) <=k) {
                    return true;
                }
               j = j+1;
            }
        }
        return false;
    }

}