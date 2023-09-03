import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int[] nums = {4,1,2,3};
        int[] test = sortEvenOdd(nums);
        System.out.println(Arrays.toString(test));
    }

    public static int[] sortEvenOdd (int[] nums) {
        if(nums.length<3)
            return nums;
        List<Integer> odd=new ArrayList<>();
        List<Integer> even=new ArrayList<>();
        int ans[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            if (i%2 == 0)
                even.add(nums[i]);
            else
                odd.add(nums[i]);
        }

        Collections.sort(even);
        Collections.sort(odd);
        Collections.reverse(odd);

        int j=0;
        int k=0;
        for(int i=0;i<nums.length;i++)
        {
            if (i%2 == 0)
                ans[i]=even.get(j++);
            else
                ans[i]=odd.get(k++);
        }
        return ans;
    }
}