import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,3};
        subsets(nums);
    }


    public static List<List<Integer>> subsets (int[] nums) {
        List<List<Integer>> myList = new ArrayList<>();
        HashSet<List<Integer>> mySet = new HashSet<>();

        mySet.add(new ArrayList<>()); // Add the empty subset

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> subset : mySet) {
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(num);
                newSubsets.add(newSubset);
            }
            mySet.addAll(newSubsets);
        }

        myList.addAll(mySet);

        return myList;
    }
}
