public class Main {
    public static void main (String[] args) {
        String password = "IloveLe3tcode!";
        boolean test  = strongPasswordCheker2(password);
        System.out.println(test);
    }

    public static boolean strongPasswordCheker2 (String password) {
        int lengthOfString = password.length();
        boolean lowerCase = false;
        boolean uppercase = false;
        boolean digit = false;
        boolean specialCharacter = false;
        boolean sameCharacter = false;
        if (lengthOfString < 8) {
            return false;
        }
        else {
            for (int i=0; i<password.length(); i++) {
                char currentChar = password.charAt(i);
                if (i<password.length() - 1 &&  currentChar == password.charAt(i+1)) {
                    sameCharacter = true;
                }
                else if (Character.isLowerCase(currentChar)) {
                    lowerCase = true;
                }
                else if (Character.isUpperCase(currentChar)) {
                    uppercase = true;
                }
                else if (Character.isDigit(currentChar)) {
                    digit = true;
                }
                else if (!Character.isLetterOrDigit(currentChar)) {
                    specialCharacter = true;
                }
            }
        }
        if (lowerCase == true && uppercase == true && digit == true && specialCharacter == true && sameCharacter == false) {
            return true;
        }
        else {
            return false;
        }
    }
}