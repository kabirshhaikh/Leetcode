import java.util.*;

public class Main {
    public static void main (String[] args) {
        int[][] items1 = {{1,1}, {3,2}, {2,3}};
        int[][] items2 = {{2,1}, {3,2}, {1,3}};
        mergeSimilarItems(items1, items2);
    }


    public static List<List<Integer>> mergeSimilarItems (int[][] items1, int[][] items2) {
        Map<Integer, Integer> valueToWeightMap = new HashMap<>();

        for (int[] item : items1) {
            valueToWeightMap.put(item[0], valueToWeightMap.getOrDefault(item[0], 0) + item[1]);
        }
        for (int[] item : items2) {
            valueToWeightMap.put(item[0], valueToWeightMap.getOrDefault(item[0], 0) + item[1]);
        }

        List<List<Integer>> mergedItems = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : valueToWeightMap.entrySet()) {
            List<Integer> item = new ArrayList<>();
            item.add(entry.getKey());
            item.add(entry.getValue());
            mergedItems.add(item);
        }

        mergedItems.sort(Comparator.comparingInt(o -> o.get(0)));

        return mergedItems;
    }
}
