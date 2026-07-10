import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Double> result = averageOfLevels(root);

        System.out.println(result);
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        //so here i define an empty output list:
        List<Double> output = new ArrayList<>();

        //base check:
        if (root == null) {
            return output;
        }

        //here i define queue data structure:
        Queue<TreeNode> q = new ArrayDeque<>();

        //at this point root is not null:
        //so i add it in the queue as first entry:
        q.offer(root);

        //then i run while loop until q is not empty:
        while (!q.isEmpty()) {
            int currLevelSize = q.size(); //here i take a snapshot of the size:
            double runningSum = 0;
            int count = 0;

            //so here i run loop until its less than size of current nodes in q:
            //then i pop each node, check if it had left and right children which are not empty and add it to queue:
            //after that i add root.val to runningSum and increase count:
            for (int i = 0; i < currLevelSize; i++) {
                TreeNode popped = q.poll(); //so this pops the first element entered

                if (popped.left != null) {
                    q.offer(popped.left);
                }

                if (popped.right != null) {
                    q.offer(popped.right);
                }

                //so here i add current popped nodes val to running sum:
                runningSum += popped.val;

                //then i increment count which will hold the count of nodes seen so far for the running sum:
                count++;
            }

            //then i divide runningSum by count to get the average of each level:
            output.add(runningSum / count);
        }

        //in the end i return the output list:
        return output;
    }
}
