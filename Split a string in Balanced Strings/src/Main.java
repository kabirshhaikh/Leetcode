import java.sql.Array;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        String s = "RLRRLLRLRL";
        balancedStringSplit(s);
    }

    public static int balancedStringSplit (String s) {
        int count = 0;
        int rCount = 0;
        int lCount = 0;
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'R') {
                rCount = rCount + 1;
            }
            else if (ch == 'L') {
                lCount = lCount + 1;
            }
            if (rCount == lCount) {
                count = count + 1;
                lCount = 0;
                rCount = 0;
            }
        }
        System.out.println("Count :" +count);
        return count;
    }

}
