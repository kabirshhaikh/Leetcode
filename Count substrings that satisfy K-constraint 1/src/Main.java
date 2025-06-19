public class Main {
    public static void main(String[] args) {
        String s = "10101";
        int k = 1;
        int test = countKConstraintSubstrings(s, k);
        System.out.println(test);
    }

    public static int countKConstraintSubstrings(String s, int k) {
       int output = 0;
       int zeros = 0;
       int ones = 0;
       int left = 0;

       for (int right=0; right<s.length(); right++) {
           char current = s.charAt(right);
           if (current == '0') zeros++;
           if (current == '1') ones++;

           while (zeros > k && ones > k) {
               if (s.charAt(left) == '0') zeros--;
               if (s.charAt(left) == '1') ones--;
               left++;
           }

           output += right - left + 1;
       }

       return output;
    }
}
