public class Main {
    public static void main (String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        searchInsert(nums,target);
    }

    public static int searchInsert (int[] nums, int target) {
        int position = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == target) {
                position = i;
            }
            else if (nums[i] <= target) {
                position = i + 1;
            }
        }
        System.out.println("Position:" +position);
        return position;
    }

}