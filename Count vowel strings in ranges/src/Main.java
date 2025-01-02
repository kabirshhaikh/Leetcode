import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        String[] words = {"aba","bcb","ece","aa","e"};
        //1, 0, 1, 1, 1:
        //1, 1, 2, 3, 4: {1,4} -> 1(start) 4(end): 4 - 1-1 = 4 - 0 = 4
        int[][] queries = {{0,2}, {1,4}, {1,1}};
        int[] test = vowelStrings(words, queries);
        System.out.println(Arrays.toString(test));
    }


    public static int[] vowelStrings (String[] words, int[][] queries) {
        int[] output = new int[queries.length];

        int[] prefix = prefixSumArray(words);
        System.out.println(Arrays.toString(prefix));

        for (int i=0; i<queries.length; i++) {
            int[] currentQuery = queries[i];
            int start = currentQuery[0];
            int end = currentQuery[1];
            int numberOfVowelsInRange;
            if (start == 0) {
                numberOfVowelsInRange = prefix[end];
            }
            else {
                numberOfVowelsInRange = prefix[end] - prefix[start - 1];
            }

            output[i] = numberOfVowelsInRange;
        }

        return output;
    }

    public static int[] prefixSumArray (String[] words) {
      int[] prefixOutput = new int[words.length];
      int[] booleanCheck = new int[words.length];
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

      for (int i=0; i<words.length; i++) {
          String currentWord = words[i];
          if (vowels.contains(currentWord.charAt(0)) && vowels.contains(currentWord.charAt(currentWord.length() - 1))) {
              booleanCheck[i] = 1;
          }
          else {
              booleanCheck[i] = 0;
          }
      }

      prefixOutput[0] = booleanCheck[0];

      for (int i=1; i<booleanCheck.length; i++) {
          prefixOutput[i] = prefixOutput[i-1] + booleanCheck[i];
      }

      return prefixOutput;
    }
}
