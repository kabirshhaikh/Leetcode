public class Main {
    public static void main (String[] args) {
        String s = "abcdefg";
        int k = 2;
        reverseStr(s, k);
    }


    public static String reverseStr (String s, int k) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i += 2 * k) {
            int start = i;
            int end = Math.min(start + k, n);

            // Reverse the first k characters
            for (int j = end - 1; j >= start; j--) {
                sb.append(s.charAt(j));
            }

            // Append the remaining characters
            sb.append(s.substring(end, Math.min(start + 2 * k, n)));
        }

        String output = sb.toString();
        System.out.println(output);
        return output;
    }

}