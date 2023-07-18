import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String[] list1 = {"happy","sad","good"};
        String[] list2 = {"sad","happy","good"};
        findRestaurant(list1, list2);
    }

    public static String[] findRestaurant (String[] list1, String[] list2) {
        HashMap<String, Integer> myMap = new HashMap<>();
        for (int i=0; i<list1.length; i++) {
            for (int j=0; j< list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    int sum = i+j;
                    myMap.put(list1[i], sum);
                }
            }
        }
        ArrayList<String> myList = new ArrayList<>();
        int minsum = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> map : myMap.entrySet()) {
            int value = map.getValue();
            String key =  map.getKey();
            if (value < minsum) {
                minsum = value;
            }
        }
        for (Map.Entry<String, Integer> map : myMap.entrySet()) {
            int value = map.getValue();
            String key = map.getKey();
            if (value == minsum) {
                myList.add(key);
            }
        }
        String[] output = new String[myList.size()];
        myList.toArray(output);
        System.out.println(Arrays.toString(output));
        return output;
    }

}