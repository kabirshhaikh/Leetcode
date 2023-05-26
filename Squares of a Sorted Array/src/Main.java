import java.util.Arrays;
public class Main {
    public static void main (String[] args) {
        int[] nums = {-4,-1,0,3,10};
        sortedSquares(nums);
    }
    public static int[] sortedSquares (int[] nums) {
        for (int i=0; i<nums.length; i++) {
            int currentElement = nums[i];
            int rootedElement = Math.abs(currentElement*currentElement);
            nums[i] = rootedElement;
        }
        Arrays.sort(nums);
        return nums;
    }
}