import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int n = 5;
        int start = 0;
        int test = xorOperation(n, start);
        System.out.println(test);
    }


    public static int xorOperation (int n, int start) {
        int[] nums = new int[n];
        int output = 0;

        for (int i=0; i<n; i++) {
            nums[i] = start + 2 * i;
        }

        for (int i=0; i<nums.length; i++) {
            output ^= nums[i];
        }

        return output;
    }
}
