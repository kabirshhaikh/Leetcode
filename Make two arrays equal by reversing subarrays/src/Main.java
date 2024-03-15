import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] target = {1,2,3,4};
        int[] arr = {2,4,1,3};
        boolean test = canBeEqual(target, arr);
        System.out.println(test);
    }


    public static boolean canBeEqual (int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);

        if (target.length != arr.length) {
            return false;
        }

        for (int i=0; i<target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }

        return true;
    }
}