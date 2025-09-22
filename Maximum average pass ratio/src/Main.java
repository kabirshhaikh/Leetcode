import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[][] classes = {{1, 2}, {3, 5}, {2, 2}};
        int extraStudents = 2;
        double test = maxAverageRation(classes, extraStudents);
        System.out.println(test);
    }

    public static double maxAverageRation(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> queue = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int i = 0; i < classes.length; i++) {
            int[] current = classes[i];
            int pass = current[0];
            int total = current[1];

            double gain = (double) (pass + 1) / (total + 1) - (double) pass / total;
            double[] entry = new double[3];
            entry[0] = gain;
            entry[1] = pass;
            entry[2] = total;

            queue.add(entry);
        }

        while (extraStudents > 0) {
            double[] top = queue.poll();

            double pass = top[1] + 1;
            double total = top[2] + 1;

            double newGain = (pass + 1) / (total + 1) - (pass / total);

            queue.add(new double[]{newGain, pass, total});
            extraStudents--;
        }

        double sum = 0.0;
        for (double[] entry : queue) {
            sum += entry[1] / entry[2];
        }

        return sum / classes.length;
    }
}
