import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int n = 0b00000000000000000000000000001011;
        int test = hammingWeight(n);
        System.out.println(test);
    }

    public static int hammingWeight (int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

}