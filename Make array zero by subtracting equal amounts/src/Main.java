import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 5, 0, 3, 5};
        int test = minimumOperations(nums);
        System.out.println(test);
    }


    public static int minimumOperations(int[] nums) {
        HashSet<Integer> mySet = new HashSet<>();

        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) {
                mySet.add(nums[i]);
            }
        }

        return mySet.size();
    }
}