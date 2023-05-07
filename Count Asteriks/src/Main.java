public class Main {
    public static void main (String[] args) {
        String s = "yo|uar|e**|b|e***au|tifu|l";
        countAsteriks(s);
    }

    public static int countAsteriks (String s) {
        int count = 0;
        boolean withinAPair = false;
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '|') {
                withinAPair = !withinAPair;
            }
            else if (ch == '*' && !withinAPair) {
                count = count + 1;
            }
        }
        System.out.println("Count: " +count);
        return count;
    }

}