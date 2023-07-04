public class Main {
    public static void main (String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2};
        maximumCount(nums);
    }

    public static int maximumCount (int[] nums) {
        int positiveNumber = 0;
        int negativeNumber = 0;
        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums[i];
            if (currentNumber < 0) {
                negativeNumber++;
            }
            else if (currentNumber > 0) {
                positiveNumber++;
            }
            else if (currentNumber == 0) {
                continue;
            }
        }
        if (negativeNumber > positiveNumber) {
            System.out.println("Negative greater" + negativeNumber);
            return  negativeNumber;
        }
        else if (negativeNumber < positiveNumber) {
            System.out.println("Positive greater" + positiveNumber);
            return positiveNumber;
        }
        else {
            System.out.println("Equal");
            return  positiveNumber;
        }
    }
}
