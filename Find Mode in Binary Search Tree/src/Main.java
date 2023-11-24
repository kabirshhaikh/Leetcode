import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        TreeNode node1 = new TreeNode(2);
        int[] test = node1.findMode(node1);
        System.out.println(Arrays.toString(test));
    }
}