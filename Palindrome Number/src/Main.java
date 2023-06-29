public class Main {
    public static void main (String[] args) {
        int x = -121;
        boolean test = isPalindrome(x);
        System.out.println(test);
    }

    public static boolean isPalindrome (int x) {
        String number = String.valueOf(x);
        char[] ch = number.toCharArray();

        int i=0;
        int j= ch.length-1;

        while (i<j) {
            char leftChar = ch[i];
            char rightChar = ch[j];

            if (leftChar == rightChar) {
                i++;
                j--;
            }
            else {
                return false;
            }

        }
        return true;
    }

}