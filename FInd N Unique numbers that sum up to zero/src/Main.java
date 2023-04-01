import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int length = 4;
        sumZero(length);
    }

    public static int[] sumZero (int n) {
        int[] result = new int[n];

       for (int i=1 ; i<n; i+=2) {
           int value = i-(2*i);
           int value2 = i;
           result[i] = value;
           result[i-1] = value2;
       }

        System.out.println(Arrays.toString(result));
        return result;
    }
}