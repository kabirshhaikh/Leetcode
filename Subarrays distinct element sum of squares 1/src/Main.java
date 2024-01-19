import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(1);
        sumCounts(nums);
    }


    public static int sumCounts (List<Integer> nums) {
       int sum = 0;

       for (int i=0; i<nums.size(); i++) {
           sum = sum + 1;
           HashSet<Integer> mySet = new HashSet<>();
           if (!mySet.contains(nums.get(i))) {
               mySet.add(nums.get(i));
           }
           for (int j=i+1; j<nums.size(); j++) {
               if (!mySet.contains(nums.get(j))) {
                   mySet.add(nums.get(j));
               }
               sum = sum + mySet.size() * mySet.size();
           }
       }

        return sum;
    }
}