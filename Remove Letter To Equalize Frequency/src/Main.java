import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String word = "aazz";
        boolean test = equalFrequency(word);
        System.out.println(test);
    }

    public static boolean equalFrequency(String word) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        //Count characters
        //define unic characters
        for (char ch : word.toCharArray()) {
            map.merge(ch, 1, Integer::sum);
            set.add(ch);
        }

        //Iterate through unique characters
        for (char ch : set) {
            Map<Character, Integer> copyMap = new HashMap<>(map); //Create every time copy of Map
            copyMap.merge(ch, -1, Integer::sum); //For every character decreased count

            if (copyMap.get(ch) == 0) { //If count of character becames 0, delete it from map
                copyMap.remove(ch);
            }

            //Check is frequency unic for all characters when make one deletion
            Set<Integer> freq = new HashSet<>(copyMap.values());
            if (freq.size() == 1) {
                return true;
            }
        }
        return false;
    }
}
