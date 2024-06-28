public class Main {
    public static void main (String[] args) {
        String s = "cb34";
        String test = clearDigits(s);
        System.out.println(test);
    }

    public static String clearDigits (String s) {
        StringBuilder sb = new StringBuilder(s);

        while (true) {
            boolean digitFound = false;
            for (int i=0; i<sb.length(); i++) {
                if (Character.isDigit(sb.charAt(i))) {
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i-1);
                    digitFound = true;
                    break;
                }
            }

            if (!digitFound) {
                break;
            }
        }

        return sb.toString();
    }





}
