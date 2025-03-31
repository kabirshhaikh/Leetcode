import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> list = partitionLabels(s);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }

    }

    private static List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> lastOccurrence = new HashMap<>();

        // Store the last index of each character
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence.put(s.charAt(i), i);
        }

        int end = 0;
        int anchor = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            end = Math.max(end, lastOccurrence.get(currentChar));

            if (i == end) {
                list.add(end - anchor + 1);
                anchor = i + 1;
            }
        }

        return list;
    }

}
