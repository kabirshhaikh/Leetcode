public class Main {
    public static void main (String[] args) {
        int x = 8;
        int test = mySqrt(x);
        System.out.println(test);
    }


    public static int mySqrt (int x) {
        double answer = Math.sqrt(x);

        StringBuilder sb = new StringBuilder(String.valueOf(answer));

        StringBuilder result = new StringBuilder();

        for (int i=0; i<sb.length(); i++) {
            if (sb.charAt(i) == '.') {
                break;
            }
            else {
                result.append(sb.charAt(i));
            }
        }

        int output = Integer.parseInt(result.toString());

        return output;
    }

}
