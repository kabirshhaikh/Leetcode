public class Main {
    public static void main (String[] args) {
        String word1 = "abcd";
        String word2 = "pq";
        mergeAlernately(word1, word2);
    }

    public static String mergeAlernately (String word1, String word2) {
        String mergedString = "";
        int i = 0;
        int j = 0;
        while (i< word1.length() && j <word2.length()) {
            mergedString += word1.charAt(i);
            mergedString += word2.charAt(j);
            i = i+1;
            j = j+1;
        }
        while (i < word1.length()) {
            mergedString += word1.charAt(i);
            i = i+1;
        }
        while (j < word2.length()) {
            mergedString += word2.charAt(j);
            j = j+1;
        }
        System.out.println(mergedString);
        return mergedString;
    }

}