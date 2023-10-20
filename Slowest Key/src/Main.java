import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[] releaseTimes = {9,29,49,50};
        String keysPressed = "cbcd";
        char test = slowestKey(releaseTimes, keysPressed);
        System.out.println(test);
    }


    public static char slowestKey (int[] releaseTimes, String keysPressed) {
        HashMap<Character, Integer> myMap = new HashMap<>();
        myMap.put(keysPressed.charAt(0), releaseTimes[0]);

        for (int i = 1; i < keysPressed.length(); i++) {
            char currentChar = keysPressed.charAt(i);
            int releaseTime = releaseTimes[i] - releaseTimes[i - 1];
            if (myMap.containsKey(currentChar)) {
                releaseTime = Math.max(releaseTime, myMap.get(currentChar));
            }
            myMap.put(currentChar, releaseTime);
        }

        int outputValue = 0;
        char outputChar = 'a';
        for (Map.Entry<Character, Integer> map : myMap.entrySet()) {
            char key = map.getKey();
            int value = map.getValue();
            if (value > outputValue || (value == outputValue && key > outputChar)) {
                outputValue = value;
                outputChar = key;
            }
        }

        return outputChar;
    }
}