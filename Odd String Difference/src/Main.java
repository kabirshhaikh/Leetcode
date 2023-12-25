import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String[] words = {"adc","wzy","abc"};
        String test = oddString(words);
        System.out.println(test);
    }

    public static String oddString (String[] words) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        int n = words.length;
        for(int i=0; i<n; i++){
            List<Integer> arr = new ArrayList<Integer>();
            for(int j=0; j<words[i].length()-1; j++){
                arr.add(words[i].charAt(j+1) - words[i].charAt(j));
            }
            Integer temp = map.getOrDefault(arr,0);
            map.put(arr,temp+1);
        }

        List<Integer> ans = new ArrayList<Integer>();
        for(Map.Entry<List<Integer>, Integer> m : map.entrySet()){
            if(m.getValue() == 1)
                ans = m.getKey();
        }

        for(int i=0; i<n; i++){
            List<Integer> arr = new ArrayList<Integer>();
            for(int j=0; j<words[i].length()-1; j++){
                arr.add(words[i].charAt(j+1) - words[i].charAt(j));
            }
            if(arr.equals(ans)) return words[i];
        }

        System.out.println(ans);
        return "";
    }

}