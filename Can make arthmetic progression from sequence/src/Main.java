import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] arr = {1,2,4};
        boolean test = canMakeArithmeticProgression(arr);
        System.out.println(test);
    }


    public static boolean canMakeArithmeticProgression (int[] arr) {
        Arrays.sort(arr);
        ArrayList<Integer> myList = new ArrayList<>();

        for (int i=0; i<arr.length-1; i++) {
            int difference = arr[i+1] - arr[i];
            myList.add(difference);
        }

        for (int i=0; i<myList.size()-1; i++) {
            int currentDifference = myList.get(i);
            int nextDifference = myList.get(i+1);
            if (currentDifference != nextDifference) {
                return false;
            }
        }

        return true;
    }
}