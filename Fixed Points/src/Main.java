public class Main {
    public static void main (String[] args) {
        int[] arr = {-10,-5,2,3,7};
        int test = fixedPoint(arr);
        System.out.println(test);
    }

    public static int fixedPoint (int[] arr) {
        int index = -1;

        for (int i=0; i<arr.length; i++) {
            int currentNumber = arr[i];
            int currentIndex = i;
            if (currentIndex == currentNumber) {
                index = currentIndex;
                break;
            }
        }

        return index;
    }
}