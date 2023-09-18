public class Main {
    public static void main (String[] args) {
        String s = "leEeetcode";
        String test = makeGood(s);
        System.out.println(test);
    }

    public static String makeGood (String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            sb.append(currentChar);
        }
        for (int i=0; i<sb.length()-1; i++) {
            char currentChar = sb.charAt(i);
            char nextChar = sb.charAt(i+1);
            if (Character.toLowerCase(currentChar) == Character.toLowerCase(nextChar) && currentChar != nextChar) {
                sb.deleteCharAt(i);
                sb.deleteCharAt(i);
                i = Math.max(i-2, -1);
            }
        }
        return sb.toString();
    }


}