public class Main {
    public static void main (String[] args) {
        String num = "1234";
        boolean test = isBalanced(num);
        System.out.println(test);
    }


    public static boolean isBalanced (String num) {
        int oddSum = 0;
        int evenSum = 0;

        for (int i=0; i<num.length(); i++) {
            char currentNumber = num.charAt(i);
            int number = Integer.parseInt(String.valueOf(currentNumber));
            if (i % 2 == 0) {
                evenSum = evenSum + number;
            }
            else {
                oddSum = oddSum + number;
            }
        }

       if (evenSum == oddSum) {
           return true;
       }

        return false;
    }
}
