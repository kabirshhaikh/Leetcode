public class Main {
    public static void main (String[] args) {
        String str1 = "ABCABC";
        String str2 = "ABC";
        gcdOfStrings(str1, str2);
    }

    public static String gcdOfStrings (String str1, String str2) {
        boolean isSame = false;
        for (int i=0; i<str2.length(); i++) {
            char char1  = str1.charAt(i);
            char char2 = str2.charAt(i);
            if (char1 == char2) {
                isSame = true;
            }
        }
        if (isSame == true) {
            StringBuilder sb = new StringBuilder();
            for (int i=str2.length(); i<str1.length(); i++) {
                sb.append(str1.charAt(i));
            }
            System.out.println(sb.toString());
            return sb.toString();
        }
        else {
            return "";
        }
    }

}