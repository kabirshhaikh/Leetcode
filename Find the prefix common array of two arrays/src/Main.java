import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main (String[] args) {
        int[] A ={1,2,3,4};
        int[] B = {3,1,2,4};
        int[] test = findThePrefixCommonArray(A, B);
        System.out.println(Arrays.toString(test));
    }


    public static int[] findThePrefixCommonArray (int[] A, int[] B) {
        int n = A.length;
        int[] prefixCommonArray = new int[n];

        Set<Integer> elementsInA = new HashSet<>();
        Set<Integer> elementsInB = new HashSet<>();

        for (int currentIndex = 0; currentIndex < n; ++currentIndex) {
            elementsInA.add(A[currentIndex]);
            elementsInB.add(B[currentIndex]);

            int commonCount = 0;

            for (int element : elementsInA) {
                if (elementsInB.contains(element)) {
                    ++commonCount;
                }
            }

            prefixCommonArray[currentIndex] = commonCount;
        }

        return prefixCommonArray;
    }

}
