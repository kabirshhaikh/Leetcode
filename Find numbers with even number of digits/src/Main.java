public class Main {
    public static void main (String[] test) {
        int[] nums = {12,345,2,6,7896};
        findNumbers(nums);
    }

    public static int findNumbers (int[] nums) {
        int evenNumber = 0;
        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums[i];
            String currentNumbeString = Integer.toString(currentNumber);
            if (currentNumbeString.length() % 2 == 0) {
                evenNumber = evenNumber + 1;
            }
        }
        System.out.println("Even Number:" +evenNumber);
        return evenNumber;
    }

}
