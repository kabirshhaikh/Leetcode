import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] test = findDiagonalOrder(mat);
        System.out.println(Arrays.toString(test));
    }

    //1 2 3
    //4 5 6
    //7 8 9

    public static int[] findDiagonalOrder(int[][] mat) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < mat.length; i++) {
            int[] curr = mat[i];
            for (int j = 0; j < curr.length; j++) {
                int sum = (i + j);
                map.computeIfAbsent(sum, k -> new ArrayList<>()).add(curr[j]);
            }
        }

        List<Integer> temp = new ArrayList<>();
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for (int i = 0; i < keys.size(); i++) {
            int key = keys.get(i);
            List<Integer> value = map.get(key);
            if (key % 2 == 0) {
                Collections.reverse(value);
            }
            for (int j = 0; j < value.size(); j++) {
                temp.add(value.get(j));
            }
        }

        int[] diagonal = new int[temp.size()];

        for (int i = 0; i < temp.size(); i++) {
            diagonal[i] = temp.get(i);
        }

        return diagonal;
    }
}
