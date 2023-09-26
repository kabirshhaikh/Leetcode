import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        String s = "dfa12321afd";
        int test = secondHighest(s);
        System.out.println(test);
    }

    public static int secondHighest (String s) {
        HashSet<Integer> mySet = new HashSet<>();
        for (int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                mySet.add(Integer.parseInt(String.valueOf(currentChar)));
            }
        }
        if (mySet.size() < 2) {
            return -1;
        } else {
            mySet.remove(max(mySet));
            return max(mySet);
        }
    }

    public static int max(HashSet<Integer> set) {
        int max = Integer.MIN_VALUE;
        for (int num : set) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }


}