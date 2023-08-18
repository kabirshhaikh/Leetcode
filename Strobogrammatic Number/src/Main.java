import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String num = "69";
        boolean test = isStrobogrammatic(num);
        System.out.println(test);
    }



        public static boolean isStrobogrammatic(String num) {
            StringBuilder sb = new StringBuilder();
            for (int i = num.length() - 1; i >= 0; i--) {
                char c = num.charAt(i);
                if (c == '0' || c == '1' || c == '8') {
                    sb.append(c);
                } else if (c == '6') {
                    sb.append('9');
                } else if (c == '9') {
                    sb.append('6');
                } else {
                    return false;
                }
            }
            String rotatedString = sb.toString();
            if (rotatedString.equals(num)) {
                return true;
            }
            else {
                return false;
            }
        }

}