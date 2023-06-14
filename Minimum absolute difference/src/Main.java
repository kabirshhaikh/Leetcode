import java.util.*;

public class Main {
    public static void main (String[] args) {
        int[] arr = {4,2,1,3};
        minimumAbsDifference(arr);
    }


    public static List<List<Integer>> minimumAbsDifference (int[] arr) {
        int difference = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i=0; i<arr.length-1; i++) {
            difference = Math.min(difference, arr[i+1] - arr[i]);
        }

        List<List<Integer>> myList = new ArrayList<>();

        for (int i=0; i<arr.length-1 ; i++) {
            if (arr[i+1] - arr[i] == difference) {
                myList.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return myList;
    }
}
