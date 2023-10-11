public class Main {
    public static void main (String[] args) {
        String s = "ab##";
        String t = "c#d#";
        boolean test = backSpaceCompare(s, t);
        System.out.println(test);
    }

    public static boolean backSpaceCompare (String s, String t) {
        StringBuilder sStringBuilder = new StringBuilder(s);
        StringBuilder tStringBuilder = new StringBuilder(t);
        for (int i=0; i<sStringBuilder.length(); i++) {
            if (sStringBuilder.charAt(i) == '#') {
                sStringBuilder.deleteCharAt(i);
                if (i > 0) {
                    sStringBuilder.deleteCharAt(i-1);
                    i-=2;
                }
                else {
                    i--;
                }
            }
        }
        for (int i=0; i<tStringBuilder.length(); i++) {
            if (tStringBuilder.charAt(i) == '#') {
                tStringBuilder.deleteCharAt(i);
                if (i>0) {
                    tStringBuilder.deleteCharAt(i-1);
                    i-=2;
                }
                else {
                    i--;
                }
            }
        }
        if (sStringBuilder.toString().equals(tStringBuilder.toString())) {
          return true;
        }
        else {
            return false;
        }
    }
}