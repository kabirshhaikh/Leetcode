public class Main {
    public static void main (String[] test) {
        int[] nums = {8,19,4,2,15,3};
        int original = 2;
        int tes = findFinalValue(nums, original);
        System.out.println(tes);
    }

    public static int findFinalValue (int[] nums, int original) {
        int count = original;
        boolean foundMatch = true;

        while (foundMatch) {
            foundMatch = false;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == count) {
                    count = count * 2;
                    foundMatch = true;
                    break;
                }
            }
        }

        return count;
    }



}


