import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main (String[] test) {
        numJewelsInStones("z", "ZZ");
    }

    public static int numJewelsInStones (String jewels, String stones) {
        int count = 0;
        ArrayList<Character> j = new ArrayList<>();
        ArrayList<Character> s = new ArrayList<>();
        //Storing each character of jewels in j arraylist
        for (int i=0; i<jewels.length(); i++) {
            char ch = jewels.charAt(i);
            j.add(ch);
        }
        //Storing each character of stones in s arraylist
        for (int i=0; i<stones.length(); i++) {
            char ch = stones.charAt(i);
            s.add(ch);
        }
        for (int i=0; i<j.size(); i++) {
            char ch = j.get(i);
            if (s.contains(ch)) {
                count += Collections.frequency(s, ch);
            }
        }
        System.out.println(count);
        return count;
    }
}