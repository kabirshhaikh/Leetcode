import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,13,10, 12, 31};
        int test = countDistinctIntegers(nums);
        System.out.println(test);
    }


    public static int countDistinctIntegers (int[] nums) {
        ArrayList<Integer> myList = new ArrayList<>();

        //Add elements into myList:
        for (int i=0; i<nums.length; i++) {
            myList.add(nums[i]);
        }

        for (int i=0; i<nums.length; i++) {
            String currentNumber = String.valueOf(nums[i]);
            if (currentNumber.length() == 1) {
                myList.add(nums[i]);
            }
            else {
                //If number is 2 digit then reverse
                String reversedNumber = reverseNumber(currentNumber);
                int number = Integer.parseInt(reversedNumber);
                myList.add(number);
            }
        }

        //HashSet to keep count of distinct elements:
        HashSet<Integer> mySet = new HashSet<>();

        for (int i=0; i<myList.size(); i++) {
            mySet.add(myList.get(i));
        }


        return mySet.size();
    }

    //Example Number: 13
    public static String reverseNumber (String number) {
        StringBuilder sb = new StringBuilder(number);
        int left = 0;
        int right = sb.length() - 1;

        while (left <= right) {
            char temp = sb.charAt(right);
            sb.setCharAt(right, sb.charAt(left));
            sb.setCharAt(left, temp);
            left = left + 1;
            right = right - 1;
        }

        return sb.toString();
    }
}