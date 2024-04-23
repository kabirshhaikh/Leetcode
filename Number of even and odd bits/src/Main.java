import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int n = 2;
        int[] test = evenOddBits(n);
        System.out.println(Arrays.toString(test));
    }


    public static int[] evenOddBits (int n) {
        int[] res = new int[2];
        String bit = Integer.toBinaryString(n);
        for(int i=bit.length()-1, k=0; i>=0; i--){
            if(i % 2 == 0)  res[0] += bit.charAt(k++) - '0';
            else    res[1] += bit.charAt(k++) - '0';
        }
        return res;
    }
}
