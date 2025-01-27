import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        int n = 11;
        boolean test = confusingNumber(n);
        System.out.println(test);
    }


    public static boolean confusingNumber (int n) {
        String s = String.valueOf(n);
        StringBuilder rotated = new StringBuilder();
        HashMap<Character, Character> rotationMap = new HashMap<>();
        rotationMap.put('0', '0');
        rotationMap.put('1', '1');
        rotationMap.put('6', '9');
        rotationMap.put('8', '8');
        rotationMap.put('9', '6');

        for (int i=s.length() - 1; i>=0 ; i--) {
            char currentChar = s.charAt(i);
            if (!rotationMap.containsKey(currentChar)) {
                return false;
            }
            rotated.append(rotationMap.get(currentChar));
        }

        return !rotated.toString().equals(s);
    }
}