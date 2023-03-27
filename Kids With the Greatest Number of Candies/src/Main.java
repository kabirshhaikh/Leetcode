import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] arguments) {
        int[] candies = {2,3,4,1,3};
        int extraCandies = 1;
        System.out.println(getKidsWithCandies(candies, extraCandies));
    }


    public static List<Boolean> getKidsWithCandies (int[] candies, int extraCandies) {
        int maxCandies = candies[0];

        for (int i=0; i<candies.length; i++) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }
        List<Boolean> result = new ArrayList<Boolean>();
        for (int i=0; i<candies.length; i++) {
            if (candies[i] + extraCandies >= maxCandies) {
                result.add(true);
            }
            else {
                result.add(false);
            }
        }
        return result;
    }

}