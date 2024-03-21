import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        int[] nums = {38};
        int test = sumOfEncryptedInt(nums);
        System.out.println(test);
    }



    public static int sumOfEncryptedInt (int[] nums ) {
        ArrayList<Integer> myList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            StringBuilder currentNumber = new StringBuilder(String.valueOf(nums[i]));
            int largestNumber = Integer.MIN_VALUE;
            for (int j = 0; j < currentNumber.length(); j++) {
                int currentChar = currentNumber.charAt(j) - '0';
                if (currentChar > largestNumber) {
                    largestNumber = currentChar;
                }
            }
            currentNumber.setLength(0); // Clear the StringBuilder
            currentNumber.append(largestNumber); // Append the largest digit
            myList.add(Integer.parseInt(currentNumber.toString()));
        }

        int sum = 0;

        for (int i = 0; i < myList.size(); i++) {
            sum += myList.get(i);
        }

        return sum;
    }


}