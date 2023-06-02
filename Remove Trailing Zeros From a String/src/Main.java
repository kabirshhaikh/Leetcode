public class Main {
    public static void main (String[] args) {
        String num = "51230100";
        removeTrailingZeros(num);
    }

    public static String removeTrailingZeros (String num) {
        int endIndex = num.length() - 1;
        for (int i= endIndex ; i>=0; i--) {
            if (num.charAt(i) != '0') {
                endIndex = i;
                break;
            }
        }
        String result = num.substring(0, endIndex + 1);
        System.out.println(result);
        return result;
    }

}