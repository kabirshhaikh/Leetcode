class Main {
    public static void main (String[] args) {
        int n = 16;
        boolean test = isPowerOfFour(n);
        System.out.println(test);
    }


    public static boolean isPowerOfFour (int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }
}