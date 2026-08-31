import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int n = 6;
        int[][] edges = {{0,1}, {0,2}, {1,2}, {3,4}};
        int output = countCompleteComponents(n, edges);
        System.out.println(output);
    }

    public static int countCompleteComponents(int n, int[][] edges) {
        //first i create a hashmap to track adjacency list:
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        //now i loop over edges to create AL:
        for (int i=0; i<edges.length; i++) {
            int[] curr = edges[i];
            int node1 = curr[0];
            int node2 = curr[1];

            List<Integer> node1List = map.getOrDefault(node1, new ArrayList<>());
            List<Integer> node2List = map.getOrDefault(node2, new ArrayList<>());

            node1List.add(node2);
            node2List.add(node1);

            map.put(node1, node1List);
            map.put(node2, node2List);
        }

        //now i define a counter for output:
        int counter = 0;

        //now i define a hashset to track globally visited nodes:
        HashSet<Integer> visited = new HashSet<>();

        //now i loop from 0 to n:
        for (int i=0; i<n; i++) {
            //loop over node only if not already visited:
            if (!visited.contains(i)) {
                int[] result = dfs(i, visited, map);

                if (result[1] == (result[0] * (result[0] - 1))) {
                    counter++;
                }
            }
        }


        //in the end i return counter:
        return counter;
    }

    //here i write the dfs helper recursion function of return type int[]:
    public static int[] dfs (int node, HashSet<Integer> visited, HashMap<Integer, List<Integer>> map) {
        //first base case: if a node is already visited then reutrn new int[] {0,0}:
        if (visited.contains(node)) {
            return new int[] {0,0};
        }

        //otherwise mark the current node as visited:
        visited.add(node);

        //then i define int[] array to track current level result:
        int[] result = new int[2];

        //now i grab the neighbours for this node:
        List<Integer> neighbours = map.getOrDefault(node, new ArrayList<>());

        //i set initial result array:
        result[0] = 1;
        result[1] = neighbours.size();

        //now i loop over neighbours:
        for (int i=0; i<neighbours.size(); i++) {
            int currentNeighbour = neighbours.get(i);
            int[] dfsResult = dfs(currentNeighbour, visited, map);

            //after each successfull recursion i update the current levels result output array:
            result[0] = result[0] + dfsResult[0];
            result[1] = result[1] + dfsResult[1];
        }

        //in the end i return result to calling stack function:
        return result;
    }
}


// [
//     0 -> {1,2}
//     1 -> {0,2}
//     2 -> {0,1}
//     3 -> {4}
//     4 -> {3}
// ]

// so in this problem i need dfs.

// i first create adjacency list using hashmap where key is integer node and value is list of integers meaning its neighbours.

// then i define a hashset to track globally visited nodes.

// then i run a loop starting from 0 to n-1.
// inside this i process a node if its not present in visited set.
// then i run dfs on that node it not processed already the return type of this dfs is int[].


// [
//     0 -> {1,2}
//     1 -> {0,2}
//     2 -> {0,1}
//     3 -> {4}
//     4 -> {3}
// ]

// visited = 0, 1, 2

// stack 1: 0
// 0 not visited so i add 0 to visited.
// get its neighbours: {1,2}
// loop on neighbours:
// dfs (1, visited, map)

// stack 2: 1
// 1 not visited so i mark it visited
// gets its neighbours: {0,2}
// 0 already visited skip,then process 2.
// dfs(2, visited, map)

// stack 3: 2
// 2 not visited, so mark it.
// get its neighbours: 0,1
// loop on it,
// both are globally visited no need to recurse again.
// loop end end in the end i return.









// dfs function has return type of int[], it gets visited set, map and the node itself.
// first base case i check if node is already visited i return new int[] {0,0};
// then i mark current node as visited.
// then i gets its neighbours.
// then i define int[] currentNodesProgress = new int[2];
// set currentNodesProgress[0] = 1 initially.
// set currentNodesProgress[1] = neighbours.size();

// then i run loop on neighbours.
// for each univisited globally neighbours i extract the dfs result into an int[]
// lets say int[] dfsResult = dfs(node2 , vistied, map));
// then inside loop after getting dfsResult i do
// currentNodesProgress[0] = currentNodesProgress[0] + dfsResult[0]
// currentNodesProgress[1] =currentNodesProgress [1] + dfsResult[1];
// then when loop ends i simply return currentNodesProgress;

// then going back into for loop:
// if result[1] = result[0] * (result[0] - 1) then increment counter

// and after outer for loop is over return counter
