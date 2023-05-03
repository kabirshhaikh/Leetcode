import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        int n= 2;
        isArmstrong(n);
    }

    public static boolean isArmstrong (int n) {
        ArrayList<Integer> myList = new ArrayList<>();
        String number = String.valueOf(n);
        for (int i=0; i<number.length(); i++) {
            char ch = number.charAt(i);
            int digit = Character.getNumericValue(ch);
            int output = digit * digit * digit;
            myList.add(output);
        }
        int crossCheck = 0;
        for (int i=0; i<myList.size(); i++) {
            crossCheck = crossCheck + myList.get(i);
        }
        String toBeCrossChecked = String.valueOf(crossCheck);

        if (number.equals(toBeCrossChecked)) {
            return true;
        }
        else {
            return false;
        }
    }

}
