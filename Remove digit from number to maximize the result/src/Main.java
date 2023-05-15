public class Main {
    public static void main (String[] args) {
        String number = "133235";
        char digit = '3';
        removeDigit(number, digit);
    }

    public static String removeDigit (String number, char digit) {
        String output = "";
        int counter = 0;
        int i=0;
        while (i<number.length()) {
            char currentNumber = number.charAt(i);
           if (currentNumber != digit) {
               output += currentNumber;
           }
           if (currentNumber == digit) {
               counter = counter + 1;
               if (counter > 1) {
                   output += currentNumber;
               }
           }
           i++;
        }
        if (output.compareTo(number) < 0) {
            output = number;
        }
        System.out.println("Output:" +output);
        return output;
    }

}