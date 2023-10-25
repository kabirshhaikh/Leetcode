public class Main {
    public static void main (String[] args) {
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";
        int test = shortestDistance(wordsDict, word1, word2);
        System.out.println(test);
    }

    public static int shortestDistance (String[] wordsDict, String word1, String word2) {
        int count = Integer.MAX_VALUE;
        int wordOneIndex = -1;
        int wordTwoIndex = -1;
        for (int i=0; i<wordsDict.length; i++) {
            String currentWord = wordsDict[i];
            if (currentWord.equals(word1)) {
                wordOneIndex = i;
            } else if (currentWord.equals(word2)) {
                wordTwoIndex = i;
            }
            if (wordOneIndex != -1 && wordTwoIndex != -1) {
                count = Math.min(count, Math.abs(wordTwoIndex - wordOneIndex));
            }
        }
        return count;
    }
}
