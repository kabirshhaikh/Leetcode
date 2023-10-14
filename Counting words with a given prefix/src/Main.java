public class Main {
    public static void main (String[] args) {
        String[] words = {"leetcode","win","loops","success"};
        String pref = "code";
        int test = prefixCount(words, pref);
        System.out.println(test);
    }

    public static int prefixCount (String[] words, String pref) {
        int count = 0;
        for (int i=0; i<words.length; i++) {
            String currentWord = words[i];
            boolean isPrefix = true;
            for (int j=0; j<pref.length(); j++) {
                if (currentWord.length() <=j || currentWord.charAt(j) != pref.charAt(j)) {
                    isPrefix = false;
                    break;
                }
            }
            if (isPrefix) {
                count = count + 1;
            }
        }

        return count;
    }
}