import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-20, 20};
        int test = maxSum(nums);
        System.out.println(test);
    }


    public static int maxSum(int[] nums) {
        Set<Integer> positiveNumsSet = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                positiveNumsSet.add(num);
            }
        }
        if (positiveNumsSet.isEmpty()) {
            return Arrays.stream(nums).max().getAsInt();
        }
        return positiveNumsSet.stream().mapToInt(Integer::intValue).sum();
    }
}
