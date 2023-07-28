import java.util.*;

public class Main {
    public static void main (String[] args) {
        int[] num1 = {1,1,3,2};
        int[] num2 = {2,3};
        int[] num3 = {3};
        twoOutOfThree(num1, num2, num3);
    }

    public static List<Integer> twoOutOfThree (int[] num1, int[] num2, int[] num3) {
        HashSet<Integer> hash1 = new HashSet<>();
        HashSet<Integer> hash2 = new HashSet<>();
        HashSet<Integer> hash3 = new HashSet<>();
        HashMap<Integer, Integer> myMap = new HashMap<>();
        List<Integer> mylist = new ArrayList<>();

        for (int i=0; i<num1.length; i++) {
            if (!hash1.contains(num1[i])) {
                hash1.add(num1[i]);
            }
        }

        for (int i=0; i<num2.length; i++) {
            if (!hash2.contains(num2[i])) {
                hash2.add(num2[i]);
            }
        }

        for (int i=0; i<num3.length; i++) {
            if (!hash3.contains(num3[i])) {
                hash3.add(num3[i]);
            }
        }

        Iterator<Integer> iterator1 = hash1.iterator();
        while (iterator1.hasNext()) {
            int currentNumber = iterator1.next();
            myMap.put(currentNumber, myMap.getOrDefault(currentNumber, 0) + 1);
        }

        Iterator<Integer> iterator2 = hash2.iterator();
        while (iterator2.hasNext()) {
            int currentNumber = iterator2.next();
            myMap.put(currentNumber, myMap.getOrDefault(currentNumber, 0) + 1);
        }

        Iterator<Integer> iterator3 = hash3.iterator();
        while (iterator3.hasNext()) {
            int currentNumber = iterator3.next();
            myMap.put(currentNumber, myMap.getOrDefault(currentNumber, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> map : myMap.entrySet() ) {
            int value = map.getValue();
            int key = map.getKey();
            if (value > 1) {
                mylist.add(key);
            }
        }
        return mylist;
    }
}