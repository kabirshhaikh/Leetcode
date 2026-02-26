public class Main {
    public static void main(String[] args) {
        long[] balance = {10, 100, 20, 50, 30};

        //initialize:
        Bank bank = new Bank(balance);

        //with money:
        System.out.println("Withdraw: ");
        System.out.print(bank.withdraw(3, 10));

        System.out.println(" ");

        //transfer:
        System.out.println("Transfer: ");
        System.out.print(bank.transfer(5, 1, 20));

        System.out.println(" ");

        //deposit:
        System.out.println("Deposit: ");
        System.out.print(bank.deposit(5, 20));

        System.out.println(" ");

        //transfer:
        System.out.println("Transfer: ");
        System.out.print(bank.transfer(3, 4, 15));

        System.out.println(" ");

        System.out.println("Withdraw: ");
        System.out.print(bank.withdraw(10, 50));
    }
}
