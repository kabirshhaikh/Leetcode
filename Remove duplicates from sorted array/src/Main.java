import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main (String[] test) {
        int[] nums = {-3,-1,0,0,0,3,3};
        removeDuplicates(nums);
    }

    public static int removeDuplicates (int[] nums) {
        int count = 0;
        HashSet<Integer> myHashSet = new HashSet<>();

        for (int i=0; i<nums.length; i++) {
            if (!myHashSet.contains(nums[i])) {
                myHashSet.add(nums[i]);
                count = count + 1;
            }
        }

       int[] myHashSetArray = new int[myHashSet.size()];
        Iterator<Integer> hashSetIterator = myHashSet.iterator();

        for (int i=0; i<myHashSetArray.length && hashSetIterator.hasNext(); i++) {
            myHashSetArray[i] = hashSetIterator.next();
        }

        Arrays.sort(myHashSetArray);


        for (int i=0; i<myHashSetArray.length; i++) {
            nums[i] = myHashSetArray[i];
        }

        System.out.println("Nums: array:" + Arrays.toString(nums));

        System.out.println("Count: " + count);

        return count;
    }

}