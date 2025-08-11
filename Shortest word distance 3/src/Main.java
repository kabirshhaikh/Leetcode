public class Main {
    public static void main(String[] args) {
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String words2 = "coding";
        int test = shortestWordDistance(wordsDict, word1, words2);
        System.out.println(test);
    }

    public static int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int ans = Integer.MAX_VALUE;

        if (!word1.equals(word2)) {
            Integer last1 = null;
            Integer last2 = null;

            for (int i = 0; i < wordsDict.length; i++) {
                String currentWord = wordsDict[i];

                if (currentWord.equals(word1)) {
                    last1 = i;
                    if (last2 != null) {
                        ans = Math.min(ans, Math.abs(last1 - last2));
                    }
                } else if (currentWord.equals(word2)) {
                    last2 = i;
                    if (last1 != null) {
                        ans = Math.min(ans, Math.abs(last1 - last2));
                    }
                }
            }
        } else {
            Integer prev = null;
            for (int i = 0; i < wordsDict.length; i++) {
                if (wordsDict[i].equals(word1)) {
                    if (prev != null) {
                        ans = Math.min(ans, i - prev);
                    }
                    prev = i;
                }
            }
        }

        return ans;
    }
}
