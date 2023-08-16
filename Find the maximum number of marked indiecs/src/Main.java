import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {9,2,5,4};
        int test = maxNumOfMarkedIndices(nums);
        System.out.println(test);
    }

    public static int maxNumOfMarkedIndices (int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int st=0;
        int mid=(n+1)/2;
        while(mid<n){
            if(nums[st]*2<=nums[mid]) st++;
            mid++;
        }
        return st*2;
    }

}