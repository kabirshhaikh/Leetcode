import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main (String[] args) {
        String s = "abab";
        int k = 2;
        int test = numKLenSubStrNoRepeats(s, k);
        System.out.println(test);
    }

    public static int numKLenSubStrNoRepeats (String s, int k) {
       int n = s.length();
       Set<Character> mySet = new HashSet<>();
       int outputCount = 0;

       for (int i=0; i<n-k+1;i++) {
           mySet.clear();
           for (int j=i; j<i+k; j++) {
               char currentChar = s.charAt(j);
               if (!mySet.add(currentChar)) {
                   mySet.add(currentChar);
               }
           }
           if (mySet.size() == k) {
               outputCount = outputCount + 1;
           }
       }
       return outputCount;
    }

}