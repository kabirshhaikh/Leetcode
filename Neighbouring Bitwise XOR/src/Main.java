public class Main {
    public static void main (String[] args) {
        int[] derived = {1,1,0};
        boolean test = doesValidArrayExist(derived);
        System.out.println(test);
    }

    public static boolean doesValidArrayExist (int[] derived) {
        if (isValidOriginal(derived, 0)) {
            return true;
        }

        if (isValidOriginal(derived, 1)) {
            return true;
        }

        return false;
    }

    private static boolean isValidOriginal(int[] derived, int firstValue) {
        int n = derived.length;
        int[] original = new int[n];
        original[0] = firstValue;

        for (int i = 1; i < n; i++) {
            original[i] = original[i - 1] ^ derived[i - 1];
        }

        return (original[n - 1] ^ original[0]) == derived[n - 1];
    }

}
