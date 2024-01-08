import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,1};
        int target = 1;
        int start = 0;
        int test = getMinDistance(nums, target, start);
        System.out.println(test);
    }

    public static int getMinDistance (int[] nums, int target, int start) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==target){
                int ans=Math.abs(i-start);
                min=Math.min(ans,min);
            }
        }
        return min;
    }
}