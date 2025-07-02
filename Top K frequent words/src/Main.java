import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        List<String> test = topKFrequent(words, k);
        for (int i = 0; i < test.size(); i++) {
            System.out.print(test.get(i) + ", ");
        }
    }


    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freq = new HashMap<>();
        List<String> output = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            freq.put(words[i], freq.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
                (a, b) -> {
                    if (b.getValue() != a.getValue()) {
                        return b.getValue() - a.getValue();
                    } else {
                        return a.getKey().compareTo(b.getKey());
                    }
                }
        );

        for (Map.Entry<String, Integer> map : freq.entrySet()) {
            queue.add(map);
        }

        for (int i = 0; i < k; i++) {
            Map.Entry<String, Integer> map = queue.poll();
            output.add(map.getKey());
        }

        return output;
    }
}
