import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] wordList = {"KiTe", "kite", "hare", "Hare"};
        String[] queries = {"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};
        String[] test = spellChecker(wordList, queries);
        System.out.println(Arrays.toString(test));
    }

    public static String[] spellChecker(String[] wordlist, String[] queries) {
        List<String> output = new ArrayList<>();

        //Exact match:
        HashSet<String> wordSet = new HashSet<>(Arrays.asList(wordlist));

        //Case Insensitive map:
        HashMap<String, String> caseInsensitive = new HashMap<>();

        //Vowel Error map:
        HashMap<String, String> vowelError = new HashMap<>();

        for (int i = 0; i < wordlist.length; i++) {
            String currentWordLowerCase = wordlist[i].toLowerCase();
            String devowel = devowel(currentWordLowerCase);
            caseInsensitive.putIfAbsent(currentWordLowerCase, wordlist[i]);
            vowelError.putIfAbsent(devowel, wordlist[i]);
        }

        for (int i = 0; i < queries.length; i++) {
            String currentWord = queries[i];
            String currentWordLowerCase = queries[i].toLowerCase();

            //If exact match is found add that to output:
            if (wordSet.contains(currentWord)) {
                output.add(currentWord);
                continue;
            }

            //Case insensitive:
            if (caseInsensitive.containsKey(currentWordLowerCase)) {
                output.add(caseInsensitive.get(currentWordLowerCase));
                continue;
            }

            //Vowel Error check:
            String devowel = devowel(currentWordLowerCase);
            if (vowelError.containsKey(devowel)) {
                output.add(vowelError.get(devowel));
                continue;
            }

            output.add("");
        }


        return output.toArray(new String[0]);
    }

    public static String devowel(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (isVowel(currentChar)) {
                sb.append("*");
            } else {
                sb.append(currentChar);
            }
        }

        return sb.toString();
    }

    public static boolean isVowel(char c) {
        return "aeiou".indexOf(Character.toLowerCase(c)) != -1;
    }
}
