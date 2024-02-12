import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(1);
        nums.add(5);
        nums.add(4);
        nums.add(2);
        int k = 2;
        int test = minOperations(nums, k);
        System.out.println(test);
    }

    public static int minOperations (List<Integer> nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int i = nums.size() - 1;

        for(; i > -1 && set.size() != k; i--) {
            if(nums.get(i) <= k) set.add(nums.get(i));
        }

        return nums.size() - i - 1;
    }
}