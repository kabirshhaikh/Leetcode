import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] heights = {180,165,170};
        String[] names = {"Mary","John","Emma"};
        sortPeople(names, heights);
    }

    public static String[]  sortPeople (String[] names, int[] heights) {
        for (int i=0; i<heights.length; i++) {
            for (int j=i; j<heights.length; j++) {
                if (heights[i] < heights[j]) {
                    int temp = heights[i];
                     heights[i] = heights[j];
                    heights[j] = temp;
                    String tempString = names[i];
                    names[i] = names[j];
                    names[j] = tempString;
                }
            }
        }
        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(heights));

        return names;
    }




}