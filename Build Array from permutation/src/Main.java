import java.util.Arrays;

public class Main {
    public static void main (String[] args) {

        int nums[] = {0,2,1,5,3,4};
        buildArray(nums);

    }

    public static int[] buildArray (int[] nums) {
        int[] ans = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            int currentIndex = nums[i];
            int resultIndex = nums[currentIndex];
            ans[i] = resultIndex;
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }



}