import java.util.Arrays;

public class Main {
    public static void main (String[] test) {
        int[] array = {1,2,3,4,5,6};
        shuffle(array, 3);
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] x = new int[n];
        int[] y = new int[n];
        int[] result = new int[nums.length];
        for (int i = 0; i < n; i++) {
            x[i] = nums[i];
        }

        for (int i =n ; i < nums.length ; i++) {
            y[i - n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            result[i * 2] = x[i];
            result[i * 2 + 1] = y[i];
        }

        System.out.println(Arrays.toString(result));
        return result;
    }

}