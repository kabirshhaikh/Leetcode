import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {100, 1, 1000};
        int test = maximumElementAfterDecrementingAndRearranging(arr);
        System.out.println(test);
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        //sort the array:
        //og: [100,1,1000]
        //after sort: [1,100, 1000]

        //if arr[0] != 1 then set 0th element to 1:

        //if the diff between arr[i] and arr[i-1] <= 1
        //continue:
        //else
        //arr[i] = arr[i-1] + 1;

        //[1,2, 1000]:
        //[1,2,3]

        //O(nlogn):
        Arrays.sort(arr);

        if (arr[0] != 1) {
            arr[0] = 1;
        }

        //O(n);
        for (int i=1; i<arr.length; i++) {
            int prev = arr[i-1];
            int curr = arr[i];

            if (Math.abs(prev - curr) <= 1) {
                continue;
            }
            else {
                arr[i] = prev + 1;
            }
        }

        return arr[arr.length - 1];

        //total time complexity: O(nlogn)
        //space complexity: O(1)
    }
}
