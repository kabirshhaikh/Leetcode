public class Main {
    public static void main (String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 100;
        int test = search(nums, target);
        System.out.println(test);
    }


    public static int search (int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middlePosition = (left + right) / 2;
            int middleNumber = nums[middlePosition];

            if (target == middleNumber) {
                return middlePosition;
            }
            else if (target > middleNumber) {
                left = middlePosition + 1;
            }
            else {
                right = middlePosition - 1;
            }
        }

        return -1;
    }
}
