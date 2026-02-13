import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 5, 4, 3};
        int test = longestBalanced(nums);
        System.out.println(test);
    }

    private static int longestBalanced(int[] nums) {
        int longest = 0;

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();

            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 == 0) {
                    even.add(nums[j]);
                } else {
                    odd.add(nums[j]);
                }

                if (even.size() == odd.size()) {
                    longest = Math.max(longest, j - i + 1);
                }
            }
        }

        return longest;
    }
}
