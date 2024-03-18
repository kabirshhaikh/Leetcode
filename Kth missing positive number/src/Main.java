import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        int[] arr = {1,2,3,4};
        int k = 2;
        int test = findKthPositive(arr, k);
        System.out.println(test);
    }



    public static int findKthPositive (int[] arr, int k) {
        HashSet<Integer> mySet = new HashSet<>();

        for (int i=0; i<arr.length; i++) {
            int currentNumber = arr[i];
            mySet.add(currentNumber);
        }

        int missingCount = 0;
        int candidate = 1;

        while (true) {
            if (!mySet.contains(candidate)) {
                missingCount = missingCount + 1;
                if (missingCount == k) {
                    return candidate;
                }
            }
            candidate = candidate + 1;
        }
    }
}
