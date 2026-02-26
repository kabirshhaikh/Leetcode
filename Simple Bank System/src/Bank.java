public class Bank {
    long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        //check if account1 and account2 are correct:
        if ((account1 < 1 || account1 > balance.length) || (account2 < 1 || account2 > balance.length)) {
            return false;
        }

        //get current balance of account1:
        long account1CurrentBalance = balance[account1 - 1];

        //check if money getting transferred from account 1 to 2 is less than or equal to current balance:
        if (account1CurrentBalance < money) {
            return false;
        }

        //update balance of account1:
        balance[account1 - 1] = account1CurrentBalance - money;

        //get balance of account2:
        long account2CurrentBalance = balance[account2 - 1];

        //deposit money into account2:
        balance[account2 - 1] = account2CurrentBalance + money;

        return true;
    }

    public boolean deposit(int account, long money) {
        //first check if the account exists:
        if (account < 1 || account > balance.length) {
            return false;
        }

        //get current balance:
        long currentBalance = balance[account - 1];

        //deposit new balance:
        balance[account - 1] = currentBalance + money;

        return true;
    }

    public boolean withdraw(int account, long money) {
        //first check if the account exists:
        if (account < 1 || account > balance.length) {
            return false;
        }

        //get current balance:
        long currentBalance = balance[account - 1];

        //check if money withdrawn less than or equal to current balance:
        if (money > currentBalance) {
            return false;
        }

        //withdraw balance and update:
        balance[account - 1] = currentBalance - money;

        return true;
    }
}
