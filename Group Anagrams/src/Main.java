import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> test = groupAnagrams(strs);
        for (int i = 0; i < test.size(); i++) {
            List<String> c = test.get(i);
            System.out.println(" ");
            for (int j = 0; j < c.size(); j++) {
                System.out.print(c.get(j) + ", ");
            }
        }
    }


    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> output = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            char[] currentWordChars = strs[i].toCharArray();
            Arrays.sort(currentWordChars);
            String currentWord = new String(currentWordChars);

            if (!map.containsKey(currentWord)) {
                List<String> tempList = new ArrayList<>();
                map.put(currentWord, tempList);
            }

            List<String> availableList = map.get(currentWord);
            availableList.add(strs[i]);
        }

        for (Map.Entry<String, List<String>> m : map.entrySet()) {
            String key = m.getKey();
            List<String> list = m.getValue();
            output.add(list);
        }

        return output;
    }

    //More optimized version with frequency counting:
//    private static List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> map = new HashMap<>();
//        List<List<String>> output = new ArrayList<>();
//
//        for (int i = 0; i < strs.length; i++) {
//            int[] freq = new int[26];
//            String currentWord = strs[i];
//
//            for (int j = 0; j < currentWord.length(); j++) {
//                freq[currentWord.charAt(j) - 'a']++;
//            }
//
//            StringBuilder sb = new StringBuilder();
//
//            for (int k = 0; k < freq.length; k++) {
//                sb.append("#").append(freq[k]);
//            }
//
//            String key = sb.toString();
//
//            if (!map.containsKey(key)) {
//                map.put(key, new ArrayList<>());
//            }
//
//            map.get(key).add(currentWord);
//        }
//
//        for (Map.Entry<String, List<String>> m : map.entrySet()) {
//            String key = m.getKey();
//            List<String> list = m.getValue();
//            output.add(list);
//        }
//
//        return output;
//    }
}
