import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String num = "6777133339";
        String test = largestGoodInteger(num);
        System.out.println(test);
    }


    public static String largestGoodInteger (String num) {
        HashMap<Character, Integer> myMap = new HashMap<>();

        for (int i=0; i<num.length() - 2; i++) {
            char currentCharacter = '%';
            int count = 3;
            if (i<num.length() - 1 &&  num.charAt(i) == num.charAt(i+1) && num.charAt(i+1) == num.charAt(i+2)) {
                currentCharacter = num.charAt(i);
            }
            myMap.put(currentCharacter, count);
        }

        char maxKey = '%';

        for (Map.Entry<Character, Integer> map: myMap.entrySet()) {
            char currentKey = map.getKey();
            int count = map.getValue();
            if (currentKey > maxKey) {
                maxKey = currentKey;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<3; i++) {
            sb.append(maxKey);
        }

        if (maxKey == '%') {
            return "";
        }
        else {
            return sb.toString();
        }
    }

}