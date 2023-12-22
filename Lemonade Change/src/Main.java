public class Main {
    public static void main (String[] args) {
        int[] bills = {5,5,5,10,20};
        boolean test = lemonadeChange(bills);
        System.out.println(test);
    }

    public static boolean lemonadeChange (int[] bills) {
        int fiveDollarCount = 0;
        int tenDollarCount = 0;

        for (int i = 0; i < bills.length; i++) {
            int currentBill = bills[i];

            if (currentBill == 5) {
                fiveDollarCount++;
            } else if (currentBill == 10) {
                tenDollarCount++;
                fiveDollarCount--;
            } else {
                if (tenDollarCount > 0) {
                    tenDollarCount--;
                    fiveDollarCount--;
                } else {
                    fiveDollarCount -= 3;
                }
            }

            if (fiveDollarCount < 0) {
                return false;
            }
        }

        return true;
    }
}