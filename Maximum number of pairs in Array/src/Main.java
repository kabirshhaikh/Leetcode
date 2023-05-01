import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,3,2,1,3,2,2};
        numberOfPairs(nums);
    }

    public static int[] numberOfPairs (int[] nums) {
        int[] answer = new int[2];
        ArrayList<Integer> myList = new ArrayList<>();
        int count = 0;
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            myList.add(nums[i]);
        }
       for (int i=0; i< myList.size(); i++) {
         for (int j= i+1; j< myList.size(); j++) {
             if (myList.get(i) == myList.get(j)) {
                 myList.remove(i);
                 myList.remove(j);
                 break;
             }
         }
       }
        for (int i = 0; i < myList.size(); i++) {
                if (myList.size() > 0 && myList.contains(myList.get(i))) {
                    myList.remove(i);
                    count = count + 1;
                }
        }
        count = count + 1;
        int length = myList.size();
        answer[0] = count;
        answer[1] = length;
        System.out.println(Arrays.toString(answer));
        return answer;
    }

}
