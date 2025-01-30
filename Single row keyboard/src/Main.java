import java.util.HashMap;

public class Main {
    public static void main (String[] args) {
        String keyboard = "abcdefghijklmnopqrstuvwxyz";
        String word = "cba";
        int test = calculateTime(keyboard, word);
        System.out.println(test);
    }

    //currentChar = c;
    //Current index = 0, right found at 2. update time: time = 0 + 2 = 2. currentIndex set to 2;

    //currentChar = b;
    //Current index = 2, left found at 1. update time = 2 + 1 = 3. currentIndex set to 1;

    //currentChar = a;
    //Current index = 1, left found at 0 update time = 3 + 1 = 4. currentIndex set to 0;


    public static int calculateTime (String keyboard, String word) {
       int time = 0;
       int currentIndex = 0;

       for (int i=0; i<word.length(); i++) {
           char currentChar = word.charAt(i);
           int right = currentIndex;
           int left = currentIndex;
           boolean found = false;

           while (!found) {
               if (right < keyboard.length() && keyboard.charAt(right) == currentChar) {
                   time = time + Math.abs(currentIndex - right);
                   currentIndex = right;
                   found = true;
               }
               else if (left >=0 && keyboard.charAt(left) == currentChar) {
                   time = time + Math.abs(currentIndex - left);
                   currentIndex = left;
                   found = true;
               }

               if (right < keyboard.length()) right++;
               if (left >=0) left--;
           }
       }
        return time;
    }


}
