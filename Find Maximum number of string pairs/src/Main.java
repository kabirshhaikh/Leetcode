public class Main {
    public static void main (String[] args) {
        String[] words = {"cd","ac","dc","ca","zz"};
        int test = maximumNumberOfStringPairs(words);
        System.out.println(test);
    }

    public static int maximumNumberOfStringPairs (String[] words) {
        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            StringBuilder sb = new StringBuilder(currentWord).reverse();
            for (int j = i + 1; j < words.length; j++) {
                if (sb.toString().equals(words[j])) {
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }
}