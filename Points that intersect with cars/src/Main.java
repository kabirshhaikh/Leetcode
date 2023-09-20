import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        List<List<Integer>> myList = new ArrayList<>();
        List<Integer> myList1 = new ArrayList<>();
        myList1.add(3);
        myList1.add(6);
        List<Integer> myList2 = new ArrayList<>();
        myList2.add(1);
        myList2.add(5);
        List<Integer> myList3 = new ArrayList<>();
        myList3.add(4);
        myList3.add(7);
        myList.add(myList1);
        myList.add(myList2);
        myList.add(myList3);
        numberOfPoints(myList);
    }

    public static int numberOfPoints (List<List<Integer>> nums) {
        HashSet<Integer> mySet = new HashSet<>();
        for (int i=0; i<nums.size(); i++) {
            List<Integer> myInternalList = nums.get(i);
            int start = myInternalList.get(0);
            int end = myInternalList.get(1);
            while (start <= end) {
                mySet.add(start);
                start++;
            }
        }
        return mySet.size();
    }
}