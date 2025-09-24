import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int numerator = 2;
        int denominator = 1;
        String test = fractionToDecimal(numerator, denominator);
        System.out.println(test);
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        boolean negative = (numerator < 0) ^ (denominator < 0);
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        if (negative) result.append("-");

        long integerPart = num / den;
        result.append(integerPart);

        long remainder = num % den;
        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");

        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                int startIndex = map.get(remainder);
                result.insert(startIndex, "(");
                result.append(")");
                break;
            }

            map.put(remainder, result.length());

            remainder *= 10;
            long digit = remainder / den;
            result.append(digit);
            remainder %= den;
        }

        return result.toString();
    }
}
