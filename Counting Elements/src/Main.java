import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        int[] arr = {1,2,3};
        int test = countElements(arr);
        System.out.println(test);
    }

    public static int countElements (int[] arr) {
        HashSet<Integer> mySet = new HashSet<>();
        int count = 0;
        for (int i=0; i<arr.length; i++) {
           mySet.add(arr[i]);
        }

        for (int i=0; i<arr.length; i++) {
            int numberToBeChecked = arr[i] + 1;
            if (mySet.contains(numberToBeChecked)) {
                count = count + 1;
            }
        }

        return count;
    }
}