import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        int[][] items = {{1,91}, {1,92}, {2,93}, {2,97}, {1,60}, {2,77}, {1,65}, {1,87}, {1,100}, {2,100}, {2,76}};
        int[][] test = highFive(items);
        System.out.println(Arrays.toString(test));
    }


    public static int[][] highFive (int[][] items) {
        Arrays.sort(items, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(b[1], a[1]);
            }
        });

        ArrayList<int[]> result = new ArrayList<>();

        int currentStudent = -1;
        int sum = 0;
        int count = 0;

        for (int i = 0; i < items.length; i++) {
            int studentId = items[i][0];
            int score = items[i][1];

            if (studentId != currentStudent) {
                if (currentStudent != -1) {
                    result.add(new int[]{currentStudent, sum / 5});
                }

                currentStudent = studentId;
                sum = 0;
                count = 0;
            }

            if (count < 5) {
                sum += score;
                count++;
            }
        }

        if (currentStudent != -1) {
            result.add(new int[]{currentStudent, sum / 5});
        }

        return result.toArray(new int[0][]);
    }
}
