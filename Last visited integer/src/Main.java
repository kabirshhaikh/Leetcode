import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,-1,-1,-1};
        List<Integer> list = lastVisitedInteger(nums);
        for (int i=0; i<list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
    }



    private static List<Integer> lastVisitedInteger (int[] nums) {
        List<Integer> seen = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int occurrenceOfMinusOne = 0;

        for (int i=0; i<nums.length; i++) {
            int currentNum = nums[i];
            if (currentNum == -1) {
                occurrenceOfMinusOne++;

                if (occurrenceOfMinusOne <= seen.size()) {
                    ans.add(seen.get(occurrenceOfMinusOne - 1));
                }
                else {
                    ans.add(-1);
                }
            }
            else {
                seen.add(0,currentNum);
                occurrenceOfMinusOne = 0;
            }
        }

        return ans;
    }
}
