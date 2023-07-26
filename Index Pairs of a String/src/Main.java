import java.util.*;

public class Main {
    public static void main (String[] args) {
        String text = "ababa";
        String[] words = {"aba","ab"};
        indexPairs(text, words);
    }

    public static int[][] indexPairs (String text, String[] words) {
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            String temp = text;
            int index = 0;
            while(index != -1){
                index = text.indexOf(words[i],index);
                if(index != -1){
                    res.add( new int []{index, index + words[i].length() - 1});
                    index ++;
                }
            }
        }
        Collections.sort(res, (a,b) -> a[0] == b[0]? a[1] - b[1] : a[0] - b[0]);
        return res.toArray(new int[0][]);
    }

}