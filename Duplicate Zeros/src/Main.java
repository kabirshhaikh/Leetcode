import java.util.Arrays;

public class Main {
    public static void main (String[] test) {
        int[] arr = {1,0,2,3,0,4,5,0};
        duplicateZeroes(arr);
    }

    public static void duplicateZeroes (int[] arr) {
        System.out.println("Before Operation:" + Arrays.toString(arr));
        for (int i=0; i<arr.length; i++) {
            if (arr[i] ==0 ) {
                for (int j=arr.length-1; j>=i+2;j--) {
                    arr[j] = arr[j-1];
                }
                if (i+1 < arr.length) {
                    arr[i+1] = 0;
                    i++;
                }
            }
        }
        System.out.println("After Operation:" + Arrays.toString(arr));
    }

}