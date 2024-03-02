public class Main {
    public static void main (String[] args) {
        int[] nums1 = {1,10,6,2};
        int[] nums2 = {1,4,1,5};
        long test = countPairs(nums1, nums2);
        System.out.println(test);
    }



    public static long countPairs (int[] nums1, int[] nums2) {
        long output = 0;
        int leftPointer = 0;

            while (leftPointer < nums1.length) {
                int number1_1 = nums1[leftPointer];
                int number2_1 = nums2[leftPointer];
                int rightPointer = leftPointer+1;
                while (rightPointer < nums1.length) {
                    int number1_2 = nums1[rightPointer];
                    int number2_2 = nums2[rightPointer];
                    if (number1_1 + number1_2 > number2_1 + number2_2) {
                        output = output + 1;
                    }
                    rightPointer = rightPointer + 1;
                }
                leftPointer = leftPointer + 1;
            }

        return output;
    }
}