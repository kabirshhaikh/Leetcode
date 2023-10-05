import java.util.HashMap;

public class Main {
    public static void main (String[] args) {
        String s = "MCMXCIV";
        int test = romanToInt(s);
        System.out.println(test);
    }

    public static int romanToInt (String s) {
        HashMap<Character, Integer> myMap = new HashMap<>();
        myMap.put('I', 1);
        myMap.put('V', 5);
        myMap.put('X', 10);
        myMap.put('L', 50);
        myMap.put('C', 100);
        myMap.put('D', 500);
        myMap.put('M', 1000);
        int sum = 0;

        for (int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            if (i < s.length() - 1 && myMap.get(currentChar) < myMap.get(s.charAt(i + 1))) {
                sum -= myMap.get(currentChar);
            } else {
                sum += myMap.get(currentChar);
            }
        }
        return sum;
    }

}
