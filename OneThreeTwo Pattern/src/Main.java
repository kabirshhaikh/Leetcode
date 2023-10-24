import java.util.Stack;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,3,4};
        boolean test = find132Pattern(nums);
        System.out.println(test);
    }

    public static boolean find132Pattern (int[] nums) {
        int n = nums.length;
        int[] min_array = new int[n];
        Stack<Integer> stack = new Stack<>();
        min_array[0] = nums[0];
        for (int i=1; i<n; i++) {
            min_array[i] = Math.min(min_array[i-1], nums[i]);
        }
        for (int i=n-1; i>=0; i--) {
            while (!stack.isEmpty() && stack.peek() <= min_array[i]) {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() < nums[i] ) {
                return true;
            }
            stack.push(nums[i]);
        }
        return false;
    }



}