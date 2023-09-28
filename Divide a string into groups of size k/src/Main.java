import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        String s = "abcdefghi";
        int k = 3;
        char fill = 'x';
        String[] test = dividesString(s, k , fill);
        System.out.println(Arrays.toString(test));
    }

    public static String[] dividesString (String s, int k, char fill) {
        ArrayList<String> myList = new ArrayList<>();
        for (int i=0; i<s.length(); i+=k) {
            StringBuilder sb = new StringBuilder();
           for (int j=i; j<i+k && j<s.length(); j++) {
               sb.append(s.charAt(j));
           }
           if (sb.length() < k) {
               while (sb.length() < k) {
                   sb.append(fill);

               }
           }
           myList.add(sb.toString());
        }
        String[] output = new String[myList.size()];
        for (int i=0; i< myList.size(); i++) {
            output[i] = myList.get(i);
        }
        return output;
    }
}