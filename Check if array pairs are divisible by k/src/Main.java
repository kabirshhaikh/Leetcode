import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] arr = {1,2,3,4,5,10,6,7,8,9};
        int k = 5;
        boolean test = canArrange(arr, k);
        System.out.println(test);
    }

    public static boolean canArrange (int[] arr, int k) {
      int[] remainder = new int[k];
      for (int i=0; i<arr.length; i++) {
          int remain = arr[i] % k;
          if (remain < 0) {
              remain += k;
          }
          remainder[remain]++;
      }

      if (remainder[0] % 2 != 0) {
          return false;
      }

      for (int i=1; i<k/2+1; i++) {
          if (remainder[i] != remainder[k-i]) {
              return false;
          }
      }
      return true;
    }
}