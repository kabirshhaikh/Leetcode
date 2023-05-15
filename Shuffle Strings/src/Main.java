import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String s = "codeleet";
        int[] indices = {4,5,6,7,0,2,1,3};
        restoreString(s, indices);
    }

    public static String restoreString (String s, int[] indices) {
        char[] characterArray = new char[s.length()];
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            characterArray[i] = ch;
        }
        Map<Integer, Character> myMap = new HashMap<>();
        for (int i=0; i<indices.length; i++) {
            myMap.put(indices[i], characterArray[i]);
        }
        String output = "";
        for (Map.Entry<Integer, Character> entry : myMap.entrySet()) {
            char charcter = entry.getValue();
            output += charcter;
        }
        System.out.println("Output:" +output);
        return output ;
    }

}