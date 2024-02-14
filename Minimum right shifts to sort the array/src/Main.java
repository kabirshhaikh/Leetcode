import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(1);
        nums.add(4);
        int test = minimumRightShifts(nums);
        System.out.println(test);
    }


    public static int minimumRightShifts (List<Integer> nums) {
        int[] ans = new int[nums.size()];
        int min = 0;

        for(int i = 0; i < nums.size(); i++){
            if(i > 0 && nums.get(min) > nums.get(i))   min = i;
        }

        for(int i = 0; i < nums.size(); i++)    ans[(i + nums.size() - min) % nums.size()] = nums.get(i);

        for(int i = 0; i < ans.length - 1; i++)    if(ans[i] > ans[i + 1]) return -1;

        return min == 0 ? min : nums.size() - min;
    }

}