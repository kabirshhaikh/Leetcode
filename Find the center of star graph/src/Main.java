import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        int output = findCenter(edges);
        System.out.println(output);
    }

    public static int findCenter(int[][] edges) {
        //so here i define a hashmap where key is node number and value is its occurrence count:
        HashMap<Integer, Integer> map = new HashMap<>();

        //now i loop over edges and increment count for each occurrence of node:
        for (int i=0; i<edges.length; i++) {
            int[] curr = edges[i];
            map.put(curr[0], map.getOrDefault(curr[0], 0) + 1);
            map.put(curr[1], map.getOrDefault(curr[1], 0) + 1);
        }

        //now i loop over the entries of map:
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            int key = m.getKey();
            int value = m.getValue();

            //if the value meaning the count == edges.length then thats our ans return it immediately:
            if (value == edges.length) {
                return key;
            }
        }

        //otherwise if we didnt find any ans till now then return -1:
        return -1;
    }
}


// so here basically we need a find a node who has an edge with other nodes.
// so for that i can use a hashmap, where key is node and value is counter meaning how many times that node has been seen so far.
// then after recording the occurrence of node i will check whichever node == edges.length thats the center of star graph.
