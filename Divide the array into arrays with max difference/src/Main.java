import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,3,4,8,7,9,3,5,1};
        int k = 2;
        int[][] test = divideArray(nums, k);
        for (int i=0; i<test.length; i++) {
            int[] mat = test[i];
            for (int j=0; j< mat.length; j++) {
                System.out.print(test[i][j] + ", ");
            }
            System.out.println(" ");
        }
    }

    public static int[][] divideArray (int[] nums, int k) {
        Arrays.sort(nums);
        List<ArrayList<Integer>> myList = new ArrayList<>();

        for (int i=0; i<nums.length; i+=3) {
            boolean lessThanK = true;
            ArrayList<Integer> myTempList = new ArrayList<>();
            for (int j=i; j<i+2 && j<nums.length; j++) {
                if (nums[j + 1] - nums[j] > k) {
                    lessThanK = false;
                    break;
                }
            }
            if (lessThanK) {
               myTempList.add(nums[i]);
               myTempList.add(nums[i+1]);
               myTempList.add(nums[i+2]);
            }
            myList.add(myTempList);
        }


        int[][] output;
       if (myList.size() > 0) {
           int rows = myList.size();
           int columns =  myList.get(0).size();
           output = new int[rows][columns];

           for (int i=0; i< myList.size(); i++) {
               ArrayList<Integer> innerList = myList.get(i);
               for (int j=0; j< innerList.size(); j++) {
                   output[i][j] = innerList.get(j);
               }
           }
           return output;
       }
       else {
           return new int[0][0];
       }

    }
}