public class Main {
    public static void main (String[] args) {
        String[] words = {"a","b","c","ab","bc","abc"};
        String s = "abc";
        countPrefixes(words, s);
    }

    public static int countPrefixes (String[] words, String s) {
        int counter = 0;
        for (int i=0; i< words.length; i++) {
            String currentWord = words[i];
            if (s.startsWith(currentWord)) {
                counter = counter + 1;
            }
        }
        System.out.println("Counter:" +counter);
        return counter;
    }

}