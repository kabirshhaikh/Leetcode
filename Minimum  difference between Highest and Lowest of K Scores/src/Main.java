import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {9, 4, 1, 7};
        int k = 2;
        int test = minimumDifference(nums, k);
        System.out.println(test);
    }
    //sorted array = [1,4,7,9];

    //min i=0;
    //max i+k-1 = 0+2-1=1;
    //min=1
    //max=4
    //diff = 3;

    //min i = 1;
    //max i+k-1 = 1+2-1 = 2;
    //min = 4
    //max = 7
    //diff = 3;

    //min i=2;
    //max i+k-1 = 2+2-1= 3;
    //min = 7;
    //max = 9;
    //diff = 2;

    public static int minimumDifference (int[] nums, int k) {
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);

        if (nums.length <= 1) {
            return 0;
        }

        //array = [1,4,7,9]
        //i<nums.length - k + 1;
        //i = 0; 0<4-2+1= 0<3  = true

        //i=1; 1<4-2+1= 1<3 = true

        //i=2; 2<4-2+1 = 2<3 = true

        //i=3; 3<4-2+1 = 3<3 = false
        //So the for loop will break when i = 3;

        for (int i=0; i<nums.length-k+1; i++) {
            int min = nums[i];
            int max = nums[i+k-1];
            int diff = max - min;
            minDiff = Math.min(diff, minDiff);
        }

        return minDiff;
    }
}
