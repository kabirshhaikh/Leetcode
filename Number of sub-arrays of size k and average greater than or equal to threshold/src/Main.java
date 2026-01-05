public class Main {
    public static void main(String[] args) {
        int[] arr = {2,2,2,2,5,5,5,8};
        int k = 3;
        int threshold = 4;
        int test = numOfSubarrays(arr, k, threshold);
        System.out.println(test);
    }

    private static int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum = windowSum + arr[i];
        }

        if (windowSum >= threshold * k) {
            count++;
        }

        for (int right = k; right < arr.length; right++) {
            windowSum = windowSum + arr[right];
            windowSum = windowSum - arr[right - k];
            if (windowSum >= threshold * k) {
                count++;
            }
        }

        return count;
    }
}
