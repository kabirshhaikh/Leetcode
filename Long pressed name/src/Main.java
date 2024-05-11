public class Main {
    public static void main (String[] args) {
        String name = "alex";
        String typed = "aaleex";
        boolean test = isLongPressed(name, typed);
        System.out.println(test);
    }


    public static boolean isLongPressed (String name, String typed) {
        int i = 0, j = 0;

        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }

        // If there are remaining characters in typed
        while (j < typed.length() && typed.charAt(j) == typed.charAt(j - 1)) {
            j++;
        }

        // If there are remaining characters in name
        return i == name.length() && j == typed.length();
    }
}
