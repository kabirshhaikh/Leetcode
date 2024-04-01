import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        int[] nums = {3,2,6,1,4};
        int test = maxOperations(nums);
        System.out.println(test);
    }



    public static int maxOperations (int[] nums) {
        ArrayList<Integer> myList = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            myList.add(nums[i]);
        }

        int operations = 0;
        int sum = nums[0] + nums[1];

        while (myList.size() > 1) {
            int number1 = myList.get(0);
            int number2 = myList.get(1);
            int internalSum = number1 + number2;
            if (internalSum == sum) {
                operations = operations + 1;
                myList.remove(0);
                myList.remove(0);
            }
            else {
                break;
            }
        }

        return operations;
    }
}