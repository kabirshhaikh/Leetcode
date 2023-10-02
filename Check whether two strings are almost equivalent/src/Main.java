public class Main {
    public static void main (String[] args) {
        String word1 = "aaaa";
        String word2 = "bccb";
        boolean test = checkAlmostEquivalent(word1, word2);
        System.out.println(test);
    }

    public static boolean checkAlmostEquivalent (String word1, String word2) {
       int[] freq1 = new int[26];
       int[] freq2 = new int[26];
       for (int i=0; i<word1.length(); i++) {
           char currentChar = word1.charAt(i);
           freq1[currentChar - 'a']++;
       }
       for (int i=0; i<word2.length(); i++) {
           char currentChar = word2.charAt(i);
           freq2[currentChar - 'a']++;
       }
       for (int i=0; i<26; i++) {
           if (Math.abs(freq1[i] - freq2[i]) > 3) {
               return false;
           }
       }
        return true;
    }
}