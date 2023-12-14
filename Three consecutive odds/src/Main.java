public class Main {
    public static void main (String[] args) {
        int[] arr = {1,2,34,3,4,5,7,23,12};
        boolean test = threeConsecutive(arr);
        System.out.println(test);
    }

    public static boolean threeConsecutive (int[] arr) {
        int i = 0;
        int threeConsecutive = 0;
        boolean isConsecutive = false;

        while (i < arr.length) {
            int currentNumber = arr[i];

            if (currentNumber % 2 == 1) {
                threeConsecutive = threeConsecutive + 1;

                if (threeConsecutive == 3) {
                    isConsecutive = true;
                    break;
                }
            } else {
                threeConsecutive = 0;
            }
            i = i + 1;
        }

        return isConsecutive;
    }
}