import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main (String[] args) {
        int[][] items = {{1,2}, {3,2}, {2,4}, {5,6}, {3,5}};
        int[] queries = {1,2,3,4,5,6};
        int[] test = maximumBeauty(items, queries);
        System.out.println(Arrays.toString(test));
    }


    public static int[] maximumBeauty (int[][] items, int[] queries) {
        int[] output = new int[queries.length];

        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));

        int[][] sortedQueries = new int[queries.length][2];

        for (int i=0; i<queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));

        int itemIndex = 0;
        int maxBeauty = 0;

        for (int  i=0; i<sortedQueries.length; i++) {
            int queryPrice = sortedQueries[i][0];
            int queryIndex = sortedQueries[i][1];

            while (itemIndex < items.length && items[itemIndex][0] <= queryPrice) {
                maxBeauty = Math.max(maxBeauty, items[itemIndex][1]);
                itemIndex = itemIndex + 1;
            }

            output[queryIndex] = maxBeauty;
        }

        return output;
    }
}