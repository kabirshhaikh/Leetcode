import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int n = 4;
        int[][] connections = {{0,1}, {0,2}, {1,2}};
        int output = makeConnected(n, connections);
        System.out.println(output);
    }

    public static int makeConnected(int n, int[][] connections) {
        //base case check:
        //if connections.length < n-1 then return -1 immediately:
        if (connections.length < n-1) {
            return -1;
        }

        //so first i create an undirected adjacency list, where the hashmap will hold key as integer and value as list of integer meaning the neighbours:
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        //now i loop over connections to create adjacency list:
        for (int i=0; i<connections.length; i++) {
            int[] curr = connections[i];
            int connection1 = curr[0];
            int connection2 = curr[1];

            List<Integer> connection1List = map.getOrDefault(connection1, new ArrayList<>());

            List<Integer> connection2List = map.getOrDefault(connection2, new ArrayList<>());

            connection1List.add(connection2);
            connection2List.add(connection1);

            map.put(connection1, connection1List);
            map.put(connection2, connection2List);
        }

        //now i define a hashset to hold globally visited nodes:
        HashSet<Integer> visited = new HashSet<>();

        //here i define a variable called groups which will hold counts of groups:
        int groups = 0;

        //now i loop from 0 to n-1:
        for (int i=0; i<n; i++) {
            //dfs on the current node if not visited already:
            if (!visited.contains(i)) {
                dfs(i, map, visited);
                groups++;
            }
        }

        // so for this input: n = 4, connections = [[0,1],[0,2],[1,2]]
        //we have two groups:
        //first group: (0->1->2)
        //second group: (just 3) (A node which does not have any connections to itself it also a part of its own group.)

        //so in the end i return groups - 1:
        //to connect k groups into 1 it takes exactly k-1 moves:
        return groups - 1;
    }

    //this is my helper recursion function of return type void:
    public static void dfs (int node, HashMap<Integer, List<Integer>> map, HashSet<Integer> visited) {
        //base case: if the node is already visited then return we dont need to check that path again:
        if (visited.contains(node)) {
            return;
        }

        //otherwise mark the node as visited:
        visited.add(node);

        //get the list of neighbours:
        List<Integer> neighbours = map.getOrDefault(node, new ArrayList<>());

        //then loop over neighbours and mark them visited:
        for (int i=0; i<neighbours.size(); i++) {
            dfs(neighbours.get(i), map, visited);
        }
    }
}


// 0 -> {1, 2}
// 1 -> {0, 2}
// 2 -> {0,1}
// 3 -> {}

// so to minimum number of cables that we need are n-1.
// so if connections.length < n - 1 then return -1 immediately.
// otherwise we create unidirected adjacency list.
// then i create a list output which hold list of integers meaning different groups.
// then i run a for loop on n = connections.length.
// then i need a hashset to see visited nodes.
// then for each node i run a dfs and in that i add the list of connected groups into output.
// meaning
// when we run for loop starting at 0th index.
// add 0 to visited.
// list is 0->1->2.

// then we iterate on 1st index.
// dfs on it inside dfs we check if this node already visited then return.

// same for 2nd node and when we go to iterate over 3rd node.

// we check if visited no, add it to the output as list and return.

// then for loop gets over, after that we simply do connections.length - output.size() thats the minjimum number of times you need to do this in order to make all computers connected.
