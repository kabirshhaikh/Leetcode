import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main (String[] ars) {
        int[] digits = {2,1,3,0};
        int[] test = findEvenNumbers(digits);
        System.out.println(Arrays.toString(test));
    }


    public static int[] findEvenNumbers (int[] digits) {
        Set<Integer> al = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) continue;
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if(i!=j && j!=k && i!=k){
                        int num= 100*digits[i]+ 10*digits[j]+digits[k];
                        if(num%2==0)al.add(num);

                    }

                }
            }

        }
        int res []=new int [al.size()];
        int i=0;
        for(int p:al) res[i++]=p;

        Arrays.sort(res);
        return res;
    }
}
