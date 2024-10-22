import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] code = {5,2,2,3,1};
        int k = 3;
        int[] test = decrypt(code, k);
        System.out.println(Arrays.toString(test));
    }


    public static int[] decrypt (int[] code, int k) {
        int[] output = new int[code.length];

        if (k == 0) {
            for (int i=0; i<output.length; i++) {
                output[i] = 0;
            }
        }

        if (k > 0) {
            for (int i=0; i<code.length; i++) {
                int sum = 0;
                for (int j=1; j<=k; j++) {
                    sum = sum + code[(i+j) % code.length];
                }
                output[i] = sum;
            }
        }

        if (k < 0) {
            k = -k;
            for (int i=0; i<code.length; i++) {
                int sum = 0;
                for (int j=1; j<=k; j++) {
                    sum = sum + code[(i-j+code.length) % code.length];
                }
                output[i] = sum;
            }
        }
        return output;
    }
}