import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        String s = "isawsquirrelnearmysquirrelhouseohmy";
        String a = "my";
        String b = "squirrel";
        int k = 15;
        beautifulIndices(s,a,b,k);
    }


    public static List<Integer> beautifulIndices (String s, String a, String b, int k) {
        List<Integer> output= new ArrayList<>();
        List<Integer> aIndices = new ArrayList<>();
        List<Integer> bIndices = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i=0; i<=s.length() - a.length(); i++) {
            String substring = s.substring(i, i+a.length());
            if (substring.equals(a)) {
                aIndices.add(i);
            }
        }

        for (int i=0; i<=s.length() - b.length(); i++) {
            String substring = s.substring(i, i + b.length());
            if (substring.equals(b)) {
                bIndices.add(i);
            }
        }

        Collections.sort(aIndices);
        Collections.sort(bIndices);

        int i=0; int j=0;

        while (i< aIndices.size() && j < bIndices.size()) {
            int num1 = aIndices.get(i);
            int num2 = bIndices.get(j);
            if (Math.abs(num1 - num2) <= k) {
                output.add(num1);
                i = i+1;
            }
            else if (num1 < num2) {
                i = i+1;
            }
            else {
                j = j+1;
            }
        }

        return output;
    }
}