import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] test) {
        int[] nums = {13,25,83,77};
        seperateDigits(nums);
    }

    public static int[] seperateDigits (int[] nums) {
        ArrayList<Character> myList = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            String currentNumber = String.valueOf(nums[i]);
            for (int j=0; j<currentNumber.length(); j++) {
                char currentChar = currentNumber.charAt(j);
                myList.add(currentChar);
            }
        }
        int[] output = new int[myList.size()];
        for (int i=0; i<myList.size(); i++) {
            int currentNumber = Integer.parseInt(String.valueOf(myList.get(i)));
            output[i] = currentNumber;
        }
        System.out.println(Arrays.toString(output));
        return output;
    }
}