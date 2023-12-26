public class Main {
    public static void main (String[] args) {
        int[] nums = {1};
        int target = 1;
        int test = search(nums, target);
        System.out.println(test);
    }

    public static int search (int[] nums, int target) {
        int index = -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int leftNumber = nums[left];
            int rightNumber = nums[right];

            if (leftNumber == target) {
                index = left;
                break;
            }
            else if (rightNumber == target) {
                index = right;
                break;
            }

            left = left + 1;
            right = right - 1;
        }


        return index;
    }
}
