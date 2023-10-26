import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String rings = "B0B6G0R6R0R6G9";
        int test = countPoints(rings);
        System.out.println(test);
    }

    public static int countPoints (String rings) {
        HashMap<Integer, HashMap<Character, Integer>> rodColorCount = new HashMap<>();

        for (int i = 0; i < rings.length(); i += 2) {
            int rod = Integer.parseInt(String.valueOf(rings.charAt(i + 1)));
            char color = rings.charAt(i);

            // If the rod is not in the map, add it
            rodColorCount.putIfAbsent(rod, new HashMap<>());

            // Increment the count for the specific color on this rod
            rodColorCount.get(rod).put(color, rodColorCount.get(rod).getOrDefault(color, 0) + 1);
        }

        int count = 0;
        for (Map.Entry<Integer, HashMap<Character, Integer>> entry : rodColorCount.entrySet()) {
            HashMap<Character, Integer> colorCount = entry.getValue();
            if (colorCount.containsKey('R') && colorCount.containsKey('G') && colorCount.containsKey('B')) {
                count++;
            }
        }
        return count;
    }
}