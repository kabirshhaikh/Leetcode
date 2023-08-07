import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class Main {
    public static void main (String[] args) {
        int[] nums = {0,0,7,2};
        int test = distinctAverages(nums);
        System.out.println(test);
    }

    public static int distinctAverages (int[] nums) {
        ArrayList<Integer> myList = new ArrayList<>();
        for (int num : nums) {
            myList.add(num);
        }
        HashSet<Double> mySet = new HashSet<>();
        while (!myList.isEmpty()) {
            int minIndex = findMinIndex(myList);
            int maxIndex = findMax(myList);
            int minValue = myList.get(minIndex);
            int maxValue = myList.get(maxIndex);
            myList.remove(minIndex);
            if (maxIndex > minIndex) {
                maxIndex --;
            }
            myList.remove(maxIndex);
            double average = (minValue + maxValue) / 2.0;
            mySet.add(average);
        }
        return mySet.size();
    }

    public static int findMinIndex (ArrayList<Integer> list) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i=0; i< list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int findMax (ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i=0; i< list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}