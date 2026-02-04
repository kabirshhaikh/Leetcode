public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 2, 6};
        boolean test = isTrionic(nums);
        System.out.println(test);
    }

    private static boolean isTrionic(int[] nums) {
        if (nums.length < 4) {
            return false;
        }

        int n = nums.length;
        int i = 1;

        //strictly increasing:
        while (i < n && nums[i] > nums[i - 1]) {
            i++;
        }

        if (i == 1 || i == n)
            return false;

        //strictly decreasing:
        while (i < n && nums[i] < nums[i - 1]) {
            i++;
        }

        if (i == n)
            return false;

        //strictly increasing:
        while (i < n && nums[i] > nums[i - 1]) {
            i++;
        }

        return i == n;
    }
}
