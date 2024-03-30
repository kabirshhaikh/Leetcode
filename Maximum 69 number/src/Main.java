import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int num = 9669;
        int test = maximum69Number(num);
        System.out.println(test);
    }



    public static int maximum69Number (int num) {
        ArrayList<String> myList = new ArrayList<>();
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        int originalNumber = num;

        for (int i=0; i<sb.length(); i++) {
            char currentChar = sb.charAt(i);
            if (currentChar == '9') {
                char tempChar = '6';
                sb.setCharAt(i, tempChar);
            }
            else if (currentChar == '6') {
                char tempChar = '9';
                sb.setCharAt(i, tempChar);
            }
            myList.add(sb.toString());
            sb.setCharAt(i, currentChar);
        }

        for (int i=0; i< myList.size(); i++) {
            int currentNumber = Integer.parseInt(myList.get(i));
            if (currentNumber > originalNumber ) {
                originalNumber = currentNumber;
            }
        }

        return originalNumber;
    }
}
