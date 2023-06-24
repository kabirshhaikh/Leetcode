public class Main {
    public static void main (String[] args) {
        String s = "0P";
        boolean test = isPalindrome(s);
        System.out.println(test);
    }

    public static boolean isPalindrome (String s) {
        if (s==null || s.trim().isEmpty()) {
            return true;
        }
        String newString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i=0;
        int j=newString.length()-1;
        while (i<j) {
            char leftChar = newString.charAt(i);
            char rightChar = newString.charAt(j);
            if (leftChar != rightChar) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}