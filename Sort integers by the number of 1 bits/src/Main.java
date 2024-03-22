import java.util.*;

public class Main {
    public static void main (String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8};
        int[] test = sortByBits(arr);
        System.out.println(Arrays.toString(test));
    }


    public static int[] sortByBits (int[] arr) {
        int[] output = new int[arr.length];
        HashMap<Integer, Integer> myMap = new HashMap<>();

        for (int i=0; i<arr.length; i++) {
            String binary = Integer.toBinaryString(arr[i]);
            for (int j=0; j<binary.length(); j++ ) {
                int currentNumber = binary.charAt(j) - '0';
                if (currentNumber == 1) {
                    myMap.put(arr[i], myMap.getOrDefault(arr[i], 0) + 1);
                }
            }
        }



        int largestCount = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int count = map.getValue();
            if (count > largestCount ) {
                largestCount = count;
            }
        }

        int currentCount = 0;
        ArrayList<Integer> myList = new ArrayList<>();

        while (currentCount <= largestCount) {
            for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
                int key = map.getKey();
                int count = map.getValue();
                if (count == currentCount) {
                    myList.add(key);
                }
            }
            currentCount = currentCount + 1;
        }

        for (int i=0; i<myList.size(); i++) {
            output[i] = myList.get(i);
        }


        return output;
    }
}