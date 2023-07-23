import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] test = twoSum(numbers, target);
        System.out.println(Arrays.toString(test));
    }

    public static int[] twoSum (int[] numbers, int target) {
        int i=0;
        int j = numbers.length - 1;
        while (i<=j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i+1, j+1};
            }
            else if (sum < target) {
                i++;
            }
            else {
                j--;
            }
        }
        return new int[]{} ;
    }

}