import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] citations = {3,0,6,1,5};
        int test = hIndex(citations);
        System.out.println(test);
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);

        for (int i=0; i<citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }
}
