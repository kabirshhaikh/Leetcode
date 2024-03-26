import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        int a = 1;
        int b = 20;
        int test = numberCount(a, b);
        System.out.println(test);
    }



    public static int numberCount (int a, int b) {
        int output = 0;

        for (int i=a; i<=b; i++) {
            String currentNumber = String.valueOf(i);
            if (currentNumber.length() == 1) {
                output = output + 1;
            }
            else {
                HashSet<Integer> mySet = new HashSet<>();
                for (int j=0; j<currentNumber.length(); j++) {
                    int number = currentNumber.charAt(j) - '0';
                    mySet.add(number);
                }
                if (mySet.size() == currentNumber.length()) {
                    output = output + 1;
                }
            }
        }

        return output;
    }
}