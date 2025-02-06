public class Main {
    public static void main (String[] args) {
        String s = "abab";
        boolean test = repeatedSubstringPattern(s);
        System.out.println(test);
    }


    public static boolean repeatedSubstringPattern (String s) {
        for (int i=1; i<=s.length() / 2; i++) {
            if (s.length() % i == 0) {
                String substring = s.substring(0,i);
                StringBuilder sb = new StringBuilder();

                for (int j=0; j<s.length()/i; j++) {
                    sb.append(substring);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
