public class Main {
    public static void main (String[] args) {
        String[] pattern = {"a","abc","bc","d"};
        String word = "abc";
        numOfStrings(pattern, word);
    }

    public static int numOfStrings (String[] pattern , String word) {
        int counter = 0;
        for (int i=0; i< pattern.length; i++) {
            String currentWord = pattern[i];
            if (word.contains(currentWord)) {
                counter ++;
            }
        }
        System.out.println("Counter:" + counter);
        return counter;
    }

}