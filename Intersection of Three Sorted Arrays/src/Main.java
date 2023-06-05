import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,5,7,9};
        int[] arr3 = {1,3,4,5,8};
        arrayIntersection(arr1, arr2, arr3);
    }

    public static List<Integer> arrayIntersection (int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> array1 = new ArrayList<>();
        List<Integer> array2 = new ArrayList<>();
        List<Integer> array3 = new ArrayList<>();
        for (int i=0; i<arr1.length; i++) {
            array1.add(arr1[i]);
        }
        for (int i=0; i<arr2.length; i++) {
            array2.add(arr2[i]);
        }
        for (int i=0; i<arr3.length; i++) {
            array3.add(arr3[i]);
        }
        List<Integer> myList = new ArrayList<>();
        for (int i=0; i<array1.size(); i++) {
            if (array2.contains(array1.get(i)) && array3.contains(array1.get(i))) {
                myList.add(array1.get(i));
            }
        }
        if (myList.size() == 0) {
            System.out.println("Empty array");
        }
        else {
            for (int i=0; i<myList.size(); i++) {
                System.out.println(myList.get(i) + ", ");
            }
        }
        return myList;
    }
}