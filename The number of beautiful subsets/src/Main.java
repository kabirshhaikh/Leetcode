import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 4, 6};
        int k = 2;
        int test = beautifulSubsets(nums, k);
        System.out.println(test); // Output should be the number of beautiful subsets
    }

    public static int beautifulSubsets(int[] nums, int k) {
        return countBeautifulSubsets(nums, k, 0, new ArrayList<>());
    }

    private static int countBeautifulSubsets(int[] nums, int k, int index, List<Integer> currentSubset) {
        if (index == nums.length) {
            // Check if the current subset is beautiful
            if (isBeautiful(currentSubset, k)) {
                return 1;
            } else {
                return 0;
            }
        }

        // Exclude the current element
        int count = countBeautifulSubsets(nums, k, index + 1, currentSubset);

        // Include the current element
        currentSubset.add(nums[index]);
        count += countBeautifulSubsets(nums, k, index + 1, currentSubset);
        currentSubset.remove(currentSubset.size() - 1);

        return count;
    }

    private static boolean isBeautiful(List<Integer> subset, int k) {
        for (int i = 0; i < subset.size(); i++) {
            for (int j = i + 1; j < subset.size(); j++) {
                if (Math.abs(subset.get(i) - subset.get(j)) == k) {
                    return false;
                }
            }
        }
        return true;
    }
}
