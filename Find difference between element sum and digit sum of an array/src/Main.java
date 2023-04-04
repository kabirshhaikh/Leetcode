public class Main {
    public static void main (String[] args) {
        int[] test = {1,15,6,3};
        differenceOfSum(test);
    }



    public static int differenceOfSum (int[] nums) {
        int difference = 0;
        int elementSum = 0;
        int digitSum = 0;

        //Calculating the element sum:
        for (int i=0; i<nums.length; i++) {
            elementSum = elementSum + nums[i];
            String numString = Integer.toString(nums[i]);
            for (int j=0; j<numString.length(); j++) {
                char ch = numString.charAt(j);
                int digit = Character.getNumericValue(ch);
                digitSum = digitSum + digit;
            }
        }

        difference = Math.abs(elementSum - digitSum);
        System.out.println("Element sum is:" +elementSum);
        System.out.println("Digit sum is: " +digitSum);
        System.out.println("Difference is: " +difference);

        return difference;
    }



}
