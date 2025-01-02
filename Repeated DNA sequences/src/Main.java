import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> test = findRepeatedDnaSequences(s);
        System.out.println(test);
    }




    public static List<String> findRepeatedDnaSequences (String s) {
        List<String> output = new ArrayList<>();
        HashMap<String, Integer> myMap = new HashMap<>();
        if (s.length() < 10) {
            return output;
        }

        for (int i=0; i<=s.length() - 10; i++) {
            String sub = s.substring(i, i+10);
            myMap.put(sub, myMap.getOrDefault(sub, 0 ) + 1);
        }

        for (Map.Entry<String, Integer> map : myMap.entrySet()) {
            String key = map.getKey();
            int count = map.getValue();
            if (count > 1) {
                output.add(key);
            }
        }

        return output;
    }
}
