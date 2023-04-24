import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main (String[] args) {
        int[] nums = {0,1,4,6,7,10};
        int diff = 3;
        arithmeticTriplets(nums, diff);
    }

    public static int arithmeticTriplets (int[] nums, int diff) {
        List<List<Integer>> myList = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            for (int j= i+1; j<nums.length; j++) {
                for (int k=j+1; k<nums.length; k++) {
                    if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) {
                        myList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }

        }
        int output = 0;
        for (int i=0; i<myList.size(); i++) {
            output = output + 1;
        }
        System.out.println("Output:" +output);
        return  output;
    }



}
