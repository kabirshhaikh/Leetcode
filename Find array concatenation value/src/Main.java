public class Main {
    public static void main (String[] args) {
        int[] nums = {1};
        findTheArrayConcVal(nums);
    }

    public static long findTheArrayConcVal (int[] nums) {
        int i=0;
        int j=nums.length-1;
        long concatenatedValue = 0;
        if (nums.length == 1) {
            concatenatedValue = nums[0];
        }
        while (i<j) {
                String numberFromLeft = String.valueOf(nums[i]);
                String numberFromRight = String.valueOf(nums[j]);
                String concatenatedNumber = numberFromLeft + numberFromRight;
                concatenatedValue += Long.parseLong(concatenatedNumber);
                i = i+1;
                j = j-1;
                if (i==j) {
                    String remainingNumber = String.valueOf(nums[j]);
                    concatenatedValue += Long.parseLong(remainingNumber);
                    break;
                }
        }
        System.out.println("Concatenated Number:" +concatenatedValue);
        return concatenatedValue;
    }

}