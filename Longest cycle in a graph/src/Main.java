import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        int[] edges = {3,3,4,2,3};
        int output = longestCycle(edges);
        System.out.println(output);
    }

    public static int max = -1;

    public static int longestCycle(int[] edges) {
        //first i create adjacency map for the directed edges:
        HashMap<Integer, Integer> map = new HashMap<>();

        //i loop over edges to create adjacency map:
        for (int i=0; i<edges.length; i++) {
            map.put(i, edges[i]);
        }

        //now i need a globally visited set to track nodes:
        HashSet<Integer> visited = new HashSet<>();

        //now i loop over 0 to n-1 and start dfs to track max:
        for (int i=0; i<edges.length; i++) {
            //for each node i create a fresh hashmap to count each nodes first step encouner and also visited nodes from the hashmap itself:
            //type will be int, int:
            HashMap<Integer, Integer> pathMap = new HashMap<>();

            if (!visited.contains(i)) {
                dfs(i, visited, 0, pathMap, map);
            }
        }

        return max;
    }

    //now i write my dfs recursion function of return type void:
    public static void dfs (int node, HashSet<Integer> visited, int steps, HashMap<Integer, Integer> pathMap, HashMap<Integer, Integer> map) {
        //first break case: if current node is -1 then return nothing to contribute from here:
        if (node == -1) {
            return;
        }

        //second base case: if current node exists in pathMap meaning cycle detected and calculate its steps:
        if (pathMap.containsKey(node)) {
            //formula = total steps - the step number when first the node which caused cycle was detected:
            int cycleSteps = steps - pathMap.get(node);
            max = Math.max(max, cycleSteps);
            return;
        }

        //third base case:
        //if current node is present in globally visited set then return:
        if (visited.contains(node)) {
            return;
        }

        //then i add the current node into visited:
        visited.add(node);

        //otherwise i add the current node into pathMap with the current step number for that node:
        pathMap.put(node, steps);

        //after that i get the edge towards which the current node points:
        int nextNode = map.get(node);

        dfs(nextNode, visited, steps + 1, pathMap, map);
    }
}
