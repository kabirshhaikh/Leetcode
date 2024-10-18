public class Main {
    public static void main (String[] args) {
        String s ="ABFCACDB" ;
        int test = minLength(s);
        System.out.println(test);
    }

    public static int minLength (String s) {
        StringBuilder sb = new StringBuilder(s);
        int i=0;

       while (i < sb.length() - 1) {
           if (sb.charAt(i) == 'A' && sb.charAt(i+1) == 'B') {
               sb.delete(i, i+2);
               i = 0;
           }
           else if (sb.charAt(i) == 'C' && sb.charAt(i+1) == 'D') {
               sb.delete(i, i+2);
               i = 0;
           }
           else {
               i = i+1;
           }
       }

        System.out.println(sb.toString());
        return sb.length();
    }
}