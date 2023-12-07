import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int[] nums = {3,5,2,3};
        int test = minPairSum(nums);
        System.out.println(test);
    }

    public static int minPairSum (int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> myList = new ArrayList<>();

        int left = 0; int right = nums.length - 1;

        while (left < right) {
            int leftSmallest = nums[left];
            int rightLargest = nums[right];
            ArrayList<Integer> tempList = new ArrayList<>();
            tempList.add(leftSmallest);
            tempList.add(rightLargest);
            myList.add(tempList);
            left = left + 1;
            right = right - 1;
        }

        ArrayList<Integer> outputList = new ArrayList<>();

       for (int i=0; i<myList.size(); i++) {
           ArrayList<Integer> innerList = (ArrayList<Integer>) myList.get(i);
           for (int j=0; j<innerList.size(); j+=2) {
               int num1 = innerList.get(j);
               int num2 = innerList.get(j +1);
               int sum = num1 + num2;
               outputList.add(sum);
           }

       }

       int maxSumNumber = 0;

       for (int i=0; i<outputList.size(); i++) {
           int currentNumber = outputList.get(i);
           if (currentNumber > maxSumNumber) {
               maxSumNumber = currentNumber;
           }
       }

        return maxSumNumber;
    }

}