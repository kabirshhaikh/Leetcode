public class Main {
    public static void main (String[] args) {
        int[] arr = {5,7,11,13};
        int test = missingNumber(arr);
        System.out.println(test);
    }

    public static int missingNumber (int[] arr) {
        int n = arr.length;
        int difference = (arr[arr.length - 1] - arr[0]) / n;
        int expected = arr[0];
        for (int val : arr) {
            if (val != expected) return expected;
            expected += difference;
        }

        return expected;
    }
}