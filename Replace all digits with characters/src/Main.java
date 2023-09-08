public class Main {
    public static void main (String[] arg) {
        String s = "a1c1e1";
        String test = replaceDigits(s);
        System.out.println(test);
    }

    public static String replaceDigits (String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i+=2) {
            char firstChar = s.charAt(i);
            if (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                int secondChar =  Integer.parseInt(String.valueOf(s.charAt(i+1)));
                char nextChar = (char) (firstChar + secondChar);
                sb.append(firstChar).append(nextChar);
            }
            else {
                sb.append(firstChar);
            }
        }
        return sb.toString();
    }
}