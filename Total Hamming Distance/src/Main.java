import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {4,14,2};
        int test = totalHammingDistance(nums);
        System.out.println(test);
    }



    public static int totalHammingDistance (int[] nums) {
        int totalDistance = 0;

        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                int xor = nums[i] ^ nums[j];
                int distance = Integer.bitCount(xor);
                totalDistance = totalDistance + distance;
            }
        }

        return totalDistance;
    }
}
