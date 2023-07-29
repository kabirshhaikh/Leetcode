import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        String[] words = {"hello","world","leetcode"};
        String chars  = "welldonehoneyr";
        int count = countCharacters(words, chars);
        System.out.println(count);
    }

    public static int countCharacters (String[] words, String chars) {
        HashMap<Character, Integer> myMap = new HashMap<>();
        int res = 0;

        for(char ch : chars.toCharArray())
            myMap.put(ch, myMap.getOrDefault(ch, 0) + 1);

        for(String word: words)
        {
            HashMap<Character, Integer> count = new HashMap<>();
            int i = 0;

            for(; i < word.length(); i++)
            {
                char ch = word.charAt(i);

                if(myMap.containsKey(ch))
                {
                    if(count.containsKey(ch) && count.get(ch) + 1 > myMap.get(ch))
                        break;
                    count.put(ch, count.getOrDefault(ch, 0) + 1);
                }
                else
                    break;
            }
            if(i == word.length())
                res += word.length();
        }

        return res;
    }

}