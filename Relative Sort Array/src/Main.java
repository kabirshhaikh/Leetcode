import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main (String[] args) {
        int[] arr1 = {28,6,22,8,44,17};
        int [] arr2 = {22,28,8,6};
        relativeSortArray(arr1, arr2);
    }


    public static int[] relativeSortArray (int[] arr1, int[] arr2) {
        ArrayList<Integer> myList = new ArrayList<>();
       for (int i=0; i<arr2.length; i++) {
           for (int j=0; j<arr1.length; j++) {
               if (arr2[i] == arr1[j]) {
                   myList.add(arr1[j]);
               }

           }
       }
       ArrayList<Integer> remainingList = new ArrayList<>();
       for (int i=0; i<arr1.length; i++) {
           if (!myList.contains(arr1[i])) {
               remainingList.add(arr1[i]);
           }
       }
       Collections.sort(remainingList);
        for (int i=0; i<remainingList.size(); i++) {
            myList.add(remainingList.get(i));
        }
       int[] finalArray = new int[myList.size()];
       for (int i=0; i<myList.size(); i++) {
           finalArray[i] = myList.get(i);
       }
        System.out.println(Arrays.toString(finalArray));
        return finalArray;
    }

}
