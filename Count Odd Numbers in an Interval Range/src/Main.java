public class Main {
    public static void main (String[] args) {
        int low = 3;
        int high = 7;
        int test = countOdds(low, high);
        System.out.println(test);
    }

    public static int countOdds (int low, int high) {
        if (low % 2 == 0 && high % 2 == 0) {
            return (high - low) /2;
        }
        else{
            return (high - low) /2 + 1;
        }
    }
}
