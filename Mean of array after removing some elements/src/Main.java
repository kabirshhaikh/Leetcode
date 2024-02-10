import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] arr = {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3};
        double test = trimMean(arr);
        System.out.println(test);
    }

    public static double trimMean (int[] arr) {
        Arrays.sort(arr);

        int smallestIndex = (int) Math.ceil(arr.length * 0.05);
        int largestIndex = (int) Math.ceil(arr.length * 0.95);

        double sum = 0;

        for (int i = smallestIndex; i < largestIndex; i++) {
            sum += arr[i];
        }

        double output = sum / (largestIndex - smallestIndex);

        return output;
    }
}