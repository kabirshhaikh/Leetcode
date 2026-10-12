import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class WordDistance {
    private final String[] wordsDict;
    private final HashMap<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        this.wordsDict = wordsDict;
        this.map = new HashMap<>();

        for (int i = 0; i < wordsDict.length; i++) {
            String curr = wordsDict[i];
            List<Integer> list = map.getOrDefault(curr, new ArrayList<>());
            list.add(i);
            map.put(curr, list);
        }
    }

    // ["practice", "makes", "perfect", "coding", "makes"]
    // {
    //     practice -> 0,
    //     makes -> 1,
    //     perfect -> 2,
    //     coding -> 3,
    //     makes -> 4
    // }

    // coding and practice -> Math.asb(3 - 0) = 3
    // makes and coding -> Math.abs(3 - 4) = 1
    public int shortest(String word1, String word2) {
        List<Integer> one = map.getOrDefault(word1, new ArrayList<>());
        List<Integer> two = map.getOrDefault(word2, new ArrayList<>());
        int minDist = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        while (left < one.size() && right < two.size()) {
            int num1 = one.get(left);
            int num2 = two.get(right);
            minDist = Math.min(minDist, Math.abs(num1 - num2));
            if (num1 < num2) {
                left++;
            } else {
                right++;
            }
        }

        return minDist;
    }
}
