public class Main {
    public static void main (String[] args) {
        int[] arr = {1,4,2,5,3};
        sumofOddLengthSubArrays(arr);
    }
    public static int sumofOddLengthSubArrays (int[] arr) {
        int sum=0;
        int n = arr.length;
        for(int i=0; i<arr.length; i++){
            int left = i+1;
            int right = n-i;
            int k = left * right;
            int odd = (k+1)/2;
            sum = sum + odd*arr[i];
        }
        System.out.println(sum);
        return sum;
    }
}