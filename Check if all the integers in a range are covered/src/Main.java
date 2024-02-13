import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        int[][] ranges = {{1,10}, {10,20}};
        int left = 21;
        int right = 21;
        boolean test = isCovered(ranges, left, right);
        System.out.println(test);
    }


    public static boolean isCovered (int[][] ranges, int left, int right) {
        HashSet<Integer> mySet = new HashSet<>();

        for (int i = left; i <= right; i++) {
            mySet.add(i);
        }

        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = ranges[i][1];

            for (int j = start; j <= end; j++) {
                if (mySet.contains(j)) {
                    mySet.remove(j);
                }
            }
        }

        return mySet.isEmpty();
    }
}