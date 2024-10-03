import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int[] arr = {400};
        int[] test = replaceElements(arr);
        System.out.println(Arrays.toString(test));
    }


    public static int[] replaceElements (int[] arr) {
        if (arr.length == 1) {
            int[] out = new int[1];
            out[0] = -1;
            return out;
        }

        List<Integer> myList = new ArrayList<>();

        int i=0;

        while (i < arr.length) {
            int currentNumber = arr[i];
            int nextGreatestNumber = Integer.MIN_VALUE;

            for (int j=i+1; j<arr.length; j++) {
                if (arr[j] > nextGreatestNumber) {
                    nextGreatestNumber = arr[j];
                }
            }

            myList.add(nextGreatestNumber);

            i = i+1;
        }

        int[] output = new int[myList.size()];
        for (int k=0; k<myList.size(); k++) {
            output[k] = myList.get(k);
        }

        output[output.length-1] = -1;
        return output;
    }
}