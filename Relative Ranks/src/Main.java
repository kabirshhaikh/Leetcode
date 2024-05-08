import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main (String[] args) {
        int[] score = {5,4,3,2,1};
        String[] test = findRelativeRanks(score);
        System.out.println(Arrays.toString(test));
    }



    public static String[] findRelativeRanks (int[] score) {
        int n = score.length;
        String[] output = new String[n];

        // Create a HashMap to store the original positions of scores
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(score[i], i);
        }

        // Sort the scores in descending order
        Arrays.sort(score);
        for (int i = n - 1; i >= 0; i--) {
            int position = map.get(score[i]);
            if (i == n - 1) {
                output[position] = "Gold Medal";
            } else if (i == n - 2) {
                output[position] = "Silver Medal";
            } else if (i == n - 3) {
                output[position] = "Bronze Medal";
            } else {
                output[position] = String.valueOf(n - i);
            }
        }

        return output;
    }
}