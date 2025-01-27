import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        List<List<Integer>> arrays = new ArrayList<>();
        List<Integer> array1 = new ArrayList<>();
        array1.add(1);
        array1.add(2);
        array1.add(3);
        arrays.add(array1);

        List<Integer> array2 = new ArrayList<>();
        array2.add(4);
        array2.add(5);
        arrays.add(array2);

        List<Integer> array3 = new ArrayList<>();
        array3.add(1);
        array3.add(2);
        array3.add(3);
        arrays.add(array3);

        int test = maxDistance(arrays);
        System.out.println(test);
    }



    public static int maxDistance (List<List<Integer>> arrays) {
        int distance = Integer.MIN_VALUE;
        int globalMin = arrays.get(0).get(0);
        int globalMax = arrays.get(0).get(arrays.get(0).size() - 1);

        for (int i=1; i<arrays.size(); i++) {
            List<Integer> current = arrays.get(i);
            int currentMin = current.get(0);
            int currentMax = current.get(current.size() - 1);

            distance = Math.max(distance, Math.abs(currentMax - globalMin));
            distance = Math.max(distance, Math.abs(globalMax - currentMin));

            globalMin = Math.min(globalMin, currentMin);
            globalMax = Math.max(globalMax, currentMax);
        }

        return distance;
    }
}
