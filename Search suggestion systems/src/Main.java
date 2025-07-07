import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        suggestedProducts(products, searchWord);
    }


    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> output = new ArrayList<>();
        Arrays.sort(products);

        for (int i = 1; i <= searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i);
            PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> b.compareTo(a));


            for (int j = 0; j < products.length; j++) {
                if (products[j].startsWith(prefix)) {
                    heap.add(products[j]);
                    if (heap.size() > 3) {
                        heap.poll();
                    }
                }
            }

            List<String> suggestions = new ArrayList<>();
            while (!heap.isEmpty()) {
                suggestions.add(heap.poll());
            }

            Collections.reverse(suggestions);
            output.add(suggestions);
        }

        return output;
    }


}
