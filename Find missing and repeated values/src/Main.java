import java.util.*;

public class Main {
    public static void main (String[] ars) {
        int[][] grid = {{1,3}, {2,2}};
        int[] output = findMissingAndRepeatedValues(grid);
        System.out.println(Arrays.toString(output));
    }


    public static int[] findMissingAndRepeatedValues (int[][] grid) {
        HashSet<Integer> mySet = new HashSet<>();

        //Find maximum number in the grid:
        for (int i=0; i<grid.length; i++) {
            int[] array = grid[i];
            for (int j=0; j<array.length; j++) {
                int currentNumber = array[j];
                if (!mySet.contains(currentNumber)) {
                    mySet.add(currentNumber);
                }
            }
        }

        int n = mySet.size() + 1;
        int expectedSum = (n * (n+1))/2;
        int actualSum = 0;

        Iterator<Integer> iterator = mySet.iterator();
        while (iterator.hasNext()) {
           int currentNumber = iterator.next();
           actualSum = actualSum + currentNumber;
        }

        int missingValue = expectedSum - actualSum;

        int repeatedNumber = -1;
        HashMap<Integer, Integer> myMap = new HashMap<>();

        for (int i=0; i< grid.length; i++) {
            int[] array = grid[i];
            for (int j=0; j<array.length; j++) {
                int currentNumber = array[j];
                myMap.put(currentNumber, myMap.getOrDefault(currentNumber, 0 ) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int key = map.getKey();
            int value = map.getValue();
            if (value > 1) {
                repeatedNumber = key;
            }
        }

        int[] finalOutput = new int[2];
        finalOutput[0] = repeatedNumber;
        finalOutput[1] = missingValue;

        return finalOutput;
    }
}