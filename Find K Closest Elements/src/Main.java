import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        List<Integer> test = findClosestElements(arr, k, x);
        for (int i = 0; i < test.size(); i++) {
            System.out.print(test.get(i) + ", ");
        }
    }


    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> output = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;
        int bestStart = 0;

        for (int i = 0; i <= arr.length - k; i++) {
            int totalDistance = 0;

            for (int j = i; j <= i + k - 1; j++) {
                totalDistance += Math.abs(x - arr[j]);
            }

            if (totalDistance < minDistance) {
                minDistance = totalDistance;
                bestStart = i;
            }
        }

        for (int i = bestStart; i < bestStart + k; i++) {
            output.add(arr[i]);
        }

        return output;
    }
}
