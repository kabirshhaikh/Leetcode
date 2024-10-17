
public class Main {
    public static void main (String[] args) {
        int n = 10;
        int test = totalMoney(n);
        System.out.println(test);
    }


    public static int totalMoney (int n) {
        int output = 0;
        int mondayOccurrence = 1;
        int currentBalance = mondayOccurrence;

        for (int i = 0; i < n; i++) {
            output += currentBalance;

            currentBalance++;

            if ((i + 1) % 7 == 0) {
                mondayOccurrence++;
                currentBalance = mondayOccurrence;
            }
        }

        return output;
    }
}
