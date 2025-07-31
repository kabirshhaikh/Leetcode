import java.util.*;

public class Main {
    public static void main(String[] agrs) {
        int[][] tasks = {{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}};
        int[] test = getOrder(tasks);
        System.out.println(Arrays.toString(test));
    }


    public static int[] getOrder(int[][] tasks) {
        int[][] enrichedTasks = new int[tasks.length][3];

        for (int i = 0; i < tasks.length; i++) {
            int[] current = tasks[i];
            enrichedTasks[i][0] = current[0];
            enrichedTasks[i][1] = current[1];
            enrichedTasks[i][2] = i;
        }

        Arrays.sort(enrichedTasks, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[2] - b[2];
            }
        });

        List<Integer> list = new ArrayList<>();
        int time = 0;
        int i = 0;

        while (i < enrichedTasks.length || !pq.isEmpty()) {
            //I am going to add all available task from enrichedTask's who's arrival time i.e index 0 is less than or equal to time:
            while (i < enrichedTasks.length && enrichedTasks[i][0] <= time) {
                pq.offer(enrichedTasks[i]);
                i++;
            }

            //Process task if queue has any:
            if (!pq.isEmpty()) {
                int[] currentTask = pq.poll();
                time += currentTask[1];
                list.add(currentTask[2]);
            } else {
                time = enrichedTasks[i][0];
            }
        }

        int[] output = new int[list.size()];

        for (int j = 0; j < list.size(); j++) {
            output[j] = list.get(j);
        }

        return output;
    }
}
