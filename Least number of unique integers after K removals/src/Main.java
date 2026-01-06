import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 1, 3, 3, 2};
        int k = 3;
        int test = findLeastNumOfUniqueInts(arr, k);
        System.out.println(test);
    }

    private static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        //Store the freq:
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        //Make a new list which will hold values in ASC order based on freq:
        List<Integer> freqList = new ArrayList<>();
        freqList.addAll(map.values());

        //Sort the values in ASC order:
        Collections.sort(freqList);

        int index = 0;

        //Remove elements until condition is met:
        while (index < freqList.size() && k >= freqList.get(index)) {
            k = k - freqList.get(index);
            index++;
        }

        return freqList.size() - index;
    }
}
