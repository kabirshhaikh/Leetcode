import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,3,6,10,12,15};
        int test = averageValue(nums);
        System.out.println(test);
    }

    public static int averageValue (int[] nums) {
        ArrayList<Integer> myList = new ArrayList<>();

        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums[i];
            if (currentNumber % 2 == 0 && currentNumber % 3 == 0) {
                myList.add(currentNumber);
            }
        }

        int length = myList.size();

        if (length == 0) {
            return 0;
        }

        int sum = 0;

        for (int i=0; i<myList.size(); i++ ) {
            int currentNumber = myList.get(i);
            sum = sum + currentNumber;
        }

        int output = sum / length;

        return output;
    }
}
