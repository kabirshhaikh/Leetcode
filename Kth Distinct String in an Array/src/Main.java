import java.util.*;

public class Main {
    public static void main (String[] args) {
        String[] arr = {"d","b","c","b","c","a"};
        int k = 2;
        String test = kthDistinct(arr, k);
        System.out.println(test);
    }


    public static String kthDistinct (String[] arr, int k) {
        HashMap<String, Integer> myMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String currentWord = arr[i];
            myMap.put(currentWord, myMap.getOrDefault(currentWord, 0) + 1);
        }

        int i = 0;
        for (String str : arr) {
            if (myMap.get(str) == 1 && ++i == k) {
                return str;
            }
        }

        return "";
    }

}