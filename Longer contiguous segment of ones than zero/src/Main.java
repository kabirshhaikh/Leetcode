public class Main {
    public static void main (String[] args) {
        String s = "1101";
        boolean test = checkZeroOnes(s);
        System.out.println(test);
    }


    public static boolean checkZeroOnes (String s) {
        int ones = 0;
        int zeros = 0;

        for (int i=0; i<s.length(); i++) {
            int tempOnes = 0;
            int currentOne = Integer.parseInt(String.valueOf(s.charAt(i)));
            if (currentOne == 1) {
                tempOnes = tempOnes + 1;
                for (int j=i+1; j<s.length(); j++) {
                    if (Integer.parseInt(String.valueOf(s.charAt(j))) == 1) {
                        tempOnes = tempOnes + 1;
                    }
                    else {
                        break;
                    }
                }
            }
            if (tempOnes > ones) {
                ones = tempOnes;
            }
        }

        for (int i=0; i<s.length(); i++) {
            int tempZeros = 0;
            int currentZero = Integer.parseInt(String.valueOf(s.charAt(i)));
            if (currentZero == 0) {
                tempZeros = tempZeros + 1;
                for (int j=i+1; j<s.length(); j++) {
                    if (Integer.parseInt(String.valueOf(s.charAt(j))) == 0) {
                        tempZeros = tempZeros + 1;
                    }
                    else {
                        break;
                    }
                }
            }
            if (tempZeros > zeros) {
                zeros = tempZeros;
            }
        }

        System.out.println("1 -> " +ones);
        System.out.println("0 -> " +zeros);

        if (ones == zeros) {
            return false;
        }
        else if (ones > zeros) {
            return true;
        }
        else {
            return false;
        }
    }


}