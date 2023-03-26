import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main (String[] arguments) {
        int nums[] = {1,2,1};
        getConcatenation(nums);


    }

   public static int[] getConcatenation (int[] nums) {
        int numsLength = nums.length;
        int[] ans = new int[2 * numsLength];

        for (int i=0; i<numsLength; i++) {
          ans[i] = nums[i];
        }

        for (int i=0; i<numsLength; i++) {
            ans[i + numsLength] = nums[i];
        }

       System.out.println(Arrays.toString(ans));

        return ans;
   }
}