public class Main {
    public static void main (String[] test) {
        int[] arr1 = {4,5,8};
        int[] arr2 = {10,9,1,8};
        int d = 2;
        findTheDistanceValue(arr1, arr2, d);
    }
    public static int findTheDistanceValue (int[] arr1, int[] arr2, int d) {
        int i=0;
        int j=0;
        int count = 0;
        while (i<arr1.length) {
            boolean valid = true;
            while (j<arr2.length) {
               int number1 = arr1[i];
               int number2 = arr2[j];
               int value = Math.abs(number1 - number2);
               if (value <=d) {
                   valid = false;
                   break;
               }
               j = j+1;
            }
            if (valid) {
                count = count + 1;
            }
            i = i+1;
            j=0;
        }
        System.out.println("Count:" +count);
        return count;
    }
}
