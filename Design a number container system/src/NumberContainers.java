import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class NumberContainers {
    private HashMap<Integer, Integer> myMap;
    private HashMap<Integer, TreeSet<Integer>> numberToIndices;

    public NumberContainers () {
        myMap = new HashMap<>();
        numberToIndices = new HashMap<>();
    }

    public void change(int index, int number) {
        if (myMap.containsKey(index)) {
            int oldNumber = myMap.get(index);
            if (oldNumber != number) {
                numberToIndices.get(oldNumber).remove(index);
                if (numberToIndices.get(oldNumber).isEmpty()) {
                    numberToIndices.remove(oldNumber);
                }
            }
        }

        myMap.put(index, number);
        numberToIndices.putIfAbsent(number, new TreeSet<>());
        numberToIndices.get(number).add(index);
    }

    public int find(int number) {
        if (!numberToIndices.containsKey(number) || numberToIndices.get(number).isEmpty()) {
            return -1;
        }
        return numberToIndices.get(number).first();
    }

    public static void main (String[] args) {
        NumberContainers numberContainers = new NumberContainers();
        numberContainers.change(1, 10);
        numberContainers.find(10);
    }
}
