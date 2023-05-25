public class Main {
    public static void main (String[] args) {
        int nums = 240;
        int k = 2;
        divisorSubStrings(nums, k);
    }

    public static int divisorSubStrings (int num, int k) {
        int count = 0;
        String number = Integer.toString(num);
        int i =0;
        while (i<=number.length()-k) {
            String substring = number.substring(i, i+k);
            int output = Integer.parseInt(substring);
            if (output!=0 && num % output == 0) {
                count++;
            }
            i++;
        }

        System.out.println("Count: " +count);
        return count;
    }

}