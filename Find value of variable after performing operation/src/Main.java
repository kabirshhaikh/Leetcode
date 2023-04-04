public class Main {
    public static void main (String[] args) {
        String[] oop = {"--X","X++","X++"};
        finalValueAfterOperation(oop);
    }

    public static int finalValueAfterOperation (String[] operations) {
        int x = 0;
        for (int i=0; i<operations.length; i++) {
            if (operations[i].equals("X++") || operations[i].equals("++X")) {
                x = x+1;
            }
            if (operations[i].equals("--X") || operations[i].equals("X--")) {
                x = x -1;
            }
        }
        System.out.println("Value of x is: " +x);
        return x;
    }

}