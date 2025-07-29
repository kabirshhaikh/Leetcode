import java.util.ArrayList;
import java.util.Arrays;
        import java.util.HashMap;
        import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] changed = {1, 3, 4, 2, 6, 8};
        int[] test = findOriginalArray(changed);
        System.out.println(Arrays.toString(test));

    }

    public static int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0];
        }

        HashMap<Integer, Integer> myMap = new HashMap<>();

        for (int i = 0; i < changed.length; i++) {
            myMap.put(changed[i], myMap.getOrDefault(changed[i], 0) + 1);
        }

        Arrays.sort(changed);

        List<Integer> myList = new ArrayList<>();

        for (int current : changed) {
            if (myMap.getOrDefault(current, 0) == 0) continue;

            int doubleOfCurrent = current * 2;
            if (myMap.getOrDefault(doubleOfCurrent, 0) == 0) {
                return new int[0]; // no valid double
            }

            // Pair matched
            myList.add(current);
            myMap.put(current, myMap.get(current) - 1);
            myMap.put(doubleOfCurrent, myMap.get(doubleOfCurrent) - 1);
        }

        int[] output = new int[myList.size()];

        for (int i = 0; i < myList.size(); i++) {
            output[i] = myList.get(i);
        }

        return output;
    }
}
