import java.util.HashMap;

public class Main {
    public static void main (String[] args) {
        int nums[] = {1,1,1,2,2,3};
        int test = removeDuplicates(nums);
        System.out.println(test);
    }

    public static int removeDuplicates (int[] nums) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        int newLength = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            int count = myMap.getOrDefault(currentNumber, 0) + 1;

            if (count <= 2) {
                myMap.put(currentNumber, count);
                nums[newLength] = currentNumber;
                newLength++;
            }
        }

        return newLength;
    }

}
