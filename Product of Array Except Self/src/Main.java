import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] test) {
        int[] nums = {1, 2, 3, 4};
        int[] tes = productExpectSelf(nums);
        System.out.println(Arrays.toString(tes));
    }

    public static int[] productExpectSelf(int[] nums) {
        ArrayList<Integer> myList = new ArrayList<>();
        int productSum = 1;
        int k = 1;
        while (k < nums.length) {
            productSum *= nums[k];
            k++;
        }
        myList.add(productSum);
        for (int i=1; i<nums.length; i++) {
            int left=i-1;
            int right = i+1;
            int pSum = 1;
            while (right < nums.length) {
                pSum *= nums[right];
                right++;
            }
            while (left >= 0 ) {
                pSum *= nums[left];
                left--;
            }
            myList.add(pSum);
        }
        int[] output = new int[myList.size()];
        for (int i=0; i<myList.size(); i++) {
            output[i] = myList.get(i);
        }
        return output;
    }
}



