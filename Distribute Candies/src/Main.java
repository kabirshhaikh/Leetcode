import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main (String[] args) {
        int[] candyType = {1,1,2,3};
        distributeCandies(candyType);
    }

    public static int distributeCandies (int[] candyType) {
        int count = 0;
        HashSet<Integer> myHashSet = new HashSet<>();
        for (int i=0; i<candyType.length; i++) {
            if (!myHashSet.contains(candyType[i])) {
                myHashSet.add(candyType[i]);
                count = count + 1;
            }
        }
        if (count > candyType.length/2) {
            count = candyType.length / 2;
        }
        System.out.println("Count:" +count);
        return count;
    }


}
