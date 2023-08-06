public class Main {
    public static void main (String[] args) {
        int[] nums = {3,1,3,4,2};
        int test = findDuplicate(nums);
        System.out.println(test);
    }

    public static int findDuplicate (int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Find the intersection point of the two pointers
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle (duplicate number)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

}