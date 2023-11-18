import java.util.*;

public class Main {
    public static void main (String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 2;
        int[] test = getStrongest(arr, k);
        System.out.println(Arrays.toString(test));
    }

    public static int[] getStrongest (int[] arr, int k) {
        Arrays.sort(arr);
        int m = arr[(arr.length - 1) / 2];
        int[] ans = new int[k];
        int left = 0, right = arr.length - 1;
        int index = 0;

        while (index < k) {
            if (m - arr[left] > arr[right] - m) {
                ans[index++] = arr[left++];
            } else {
                ans[index++] = arr[right--];
            }
        }

        return ans;
    }
}