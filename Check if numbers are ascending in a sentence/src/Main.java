import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        String s = "hello world 5 x 5";
        boolean test = areNumbersAscending(s);
        System.out.println(test);
    }
    public static boolean areNumbersAscending (String s) {
        ArrayList<Integer> myList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                sb.append(currentChar);
            }
            else if (sb.length() > 0) {
                myList.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            }
        }
        if (sb.length() > 0) {
            myList.add(Integer.parseInt(sb.toString()));
        }
        for (int i=0; i<myList.size()-1; i++) {
            if (myList.get(i) >= myList.get(i+1)) {
                return false;
            }
        }
        return true;
    }
}