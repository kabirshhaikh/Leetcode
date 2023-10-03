import java.text.DecimalFormat;

public class Main {
    public static void main (String[] args) {
        int n = 1234;
        String test = thousandSeparator(n);
        System.out.println(test);
    }

    public static String thousandSeparator (int n) {
        String number = Integer.toString(n);
        StringBuilder sb = new StringBuilder();
        if (number.length() <=3) {
            return number;
        }
        else {
           for (int i=0; i<number.length(); i++) {
               sb.append(number.charAt(i));
               if ((number.length() - i - 1) % 3 == 0 && i != number.length() - 1) {
                   sb.append(".");
               }
           }
        }
        return sb.toString();
    }
}