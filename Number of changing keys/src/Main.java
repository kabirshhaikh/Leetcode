public class Main {
    public static void main (String[] args) {
        String s = "aAbBcC";
        int test = countKeyChanges(s);
        System.out.println(test);
    }



    public static int countKeyChanges (String s) {
        int changes = 0;
        String STRING = s.toLowerCase();

        for (int i=0; i<STRING.length()-1; i++) {
            char currentChar = STRING.charAt(i);
            char nextChar = STRING.charAt(i+1);
            if (currentChar != nextChar) {
                changes = changes + 1;
            }
        }

        return changes;
    }
}