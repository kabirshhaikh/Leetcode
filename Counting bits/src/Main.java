import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[] test = countBits(n);
        System.out.println(Arrays.toString(test));
    }


    public static int[] countBits(int n) {
        int[] output = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            String binaryFormat = Integer.toBinaryString(i);
            int countOf1 = 0;
            for (int j = 0; j < binaryFormat.length(); j++) {
                if (binaryFormat.charAt(j) == '1') {
                    countOf1 = countOf1 + 1;
                }
            }
            output[i] = countOf1;
        }

        return output;
    }
}