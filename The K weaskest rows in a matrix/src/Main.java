import java.util.*;

public class Main {
    public static void main (String[] args) {
        int[][] mat = {{1,1,0,0,0,}, {1,1,1,1,0}, {1,0,0,0,0}, {1,1,0,0,0,}, {1,1,1,1,1}};
        int k = 3;
        int[] test = kWeakestRows(mat, k);
        System.out.println(Arrays.toString(test));
    }

    public static int[] kWeakestRows (int[][] mat, int k) {
        HashMap<Integer, Integer> myMap = new HashMap<>();

        for (int i=0; i< mat.length; i++) {
            int[] currentArray = mat[i];
            int counter = 0;
            int index = i;
            for (int j=0; j<currentArray.length; j++) {
                int currentNumber = currentArray[j];
                if (currentNumber == 1) {
                    counter = counter + 1;
                }
            }
            myMap.put(index, counter);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(myMap.entrySet());

        Collections.sort(list, Map.Entry.comparingByValue());

        int[] output = new int[k];
        for (int i = 0; i < k; i++) {
            output[i] = list.get(i).getKey();
        }

        return output;
    }
}