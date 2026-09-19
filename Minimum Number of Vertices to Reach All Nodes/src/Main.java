import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int n = 6;
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(0, 2));
        edges.add(Arrays.asList(2, 5));
        edges.add(Arrays.asList(3, 4));
        edges.add(Arrays.asList(4, 2));

        System.out.println(findSmallestSetOfVertices(n, edges));
    }

    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] visited = new boolean[n];

        for (int i = 0; i < edges.size(); i++) {
            List<Integer> curr = edges.get(i);
            int to = curr.get(1);
            visited[to] = true;
        }

        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                output.add(i);
            }
        }

        return output;
    }
}


// so basically a node at which no one points is one of the ans:
// then maybe create a boolean array of size n, for all the positions nodes in edges mark that boolean array as true maybe.

// then loop over boolean array and whichever position has false add that into final list
