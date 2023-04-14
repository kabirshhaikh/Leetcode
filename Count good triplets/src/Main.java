public class Main {
    public static void main (String[] args) {
        int[] arr = {3,0,1,1,9,7};
        int a = 7;
        int b = 2;
        int c = 3;
        countGoodTriplets(arr, a, b, c);
    }
    public static int countGoodTriplets (int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                for (int k=j+1; k<arr.length; k++) {
                    int iAndJ = (arr[i] - arr[j]);
                    int jAndK = (arr[j] - arr[k]);
                    int iAndK = (arr[i] - arr[k]);
                    if (Math.abs(iAndJ) <= a && Math.abs(jAndK) <= b && Math.abs(iAndK) <= c  ) {
                        count = count + 1;
                    }
                }
            }
        }
        System.out.println("Count: " +count);
        return count;
    }
}