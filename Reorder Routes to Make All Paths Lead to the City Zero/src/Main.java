import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int n = 6;
        int[][] connections = {{0,1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        int output = minReorder(n, connections);
        System.out.println(output);
    }

    public static int minReorder(int n, int[][] connections) {
        //here i maintain a map of integer and list of int[] for the undirected edges:
        HashMap<Integer, List<int[]>> map = new HashMap<>();

        //here i loop over connections to build the adjacency list:
        for (int i=0; i<connections.length; i++) {
            int[] curr = connections[i];
            int roadA = curr[0];
            int roadB = curr[1];

            List<int[]> roadAList = map.getOrDefault(roadA, new ArrayList<>());
            List<int[]> roadBList = map.getOrDefault(roadB, new ArrayList<>());

            //1 meaning original direction:
            roadAList.add(new int[] {roadB, 1});

            //0 meaning reversed direction:
            roadBList.add(new int[] {roadA, 0});

            //now i update the map:
            map.put(roadA, roadAList);
            map.put(roadB, roadBList);
        }

        //now i perform the dfs starting from 0 and passing inital parent as -1;
        //in the end i get a count from the dfs recursion method:
        int count = dfs(0, -1, map);

        //and then i return this count:
        return count;
    }

    public static int dfs (int node, int parent, HashMap<Integer, List<int[]>> map) {
        int count = 0;
        //now here i get the list of neighbours for the current node:
        List<int[]> neighbours = map.getOrDefault(node, new ArrayList<>());

        //now i loop over the neighbours:
        for (int i=0; i<neighbours.size(); i++) {
            int[] curr = neighbours.get(i);

            int currNode = curr[0];
            int direction = curr[1];

            //base case check:
            if (currNode == parent) {
                continue; // meaning it will go back and perform dfs on parent node from where we just came:
            }

            //now i check if direction is 1 and since we are going outward from 0 it needs to be flipped so i increment count:
            if (direction == 1) {
                count++;
            }

            //now i perform recursion over currNode:
            count += dfs(currNode, node, map);
        }

        return count;
    }
}


//so this is how the algo will work:
//here i maintain an output counter to increment each flipped edge:
//first i create an adjacency list which will be an undirected map,
//where in this map the key is the curr[0] and value is list of int[] where if original road then int[1] is 1 else 0 and int[0] is curr[1].

// after that i start the recursion and pass a parent.
//now since we are moving outward from 0 whichever neigbours's curr[1] is 1 then we increment count:
// the recursion starts from 0 and parent initally is -1.
//other wise get the list of int from map for this node else empty arraylist.
//then loop on it
//if the neighbours curr[0] same as parent then skip
//inside the loop i get current int[] from list
//if curr[1] is 1 then increment output counter
//and then dfs on curr[0]


