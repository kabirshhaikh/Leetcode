import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] parent = {-1, 0, 0, 1, 1, 2};
        String s = "abacbe";
        int output = longestPath(parent, s);
        System.out.println(output);
    }

    static int max = 0;

    public static int longestPath(int[] parent, String s) {
        //so first i define the adjacency list:
        //i define a hashmap which will hold integer as key and list of integer as value:
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) continue;
            int p = parent[i];
            List<Integer> children = map.getOrDefault(p, new ArrayList<>());
            children.add(i);
            map.put(p, children);
        }

        //now i create a hashmap to map character to each ith node:
        HashMap<Integer, Character> cmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            cmap.put(i, ch);
        }

        //now i will perform dfs starting from 0:
        dfs(0, map, cmap);

        //in the end i return max:
        return max;
    }

    //now here i write my recursion dfs method of return type int:
    public static int dfs(int node, HashMap<Integer, List<Integer>> map, HashMap<Integer, Character> cmap) {
        //here i get the character mapping for this node:
        char ch = cmap.get(node);

        //now here i get the list of neighbours:
        List<Integer> neighbours = map.getOrDefault(node, new ArrayList<>());

        //now i define two integer bestResultOne and bestResultTwo:
        int bestResultOne = 0;
        int bestResultTwo = 0;

        //now i loop over neighbours:
        for (int i = 0; i < neighbours.size(); i++) {
            //here i grab current neighbours character mapping:
            int currentNeighbour = neighbours.get(i);

            char currentNeighbourCh = cmap.get(currentNeighbour);

            //always perform dfs:
            int neighbourDfsResult = dfs(currentNeighbour, map, cmap);

            //if ch == currentNeighbourCh then skip because its adjacent and thats against the rule:
            if (ch == currentNeighbourCh) {
                continue;
            }

            if (neighbourDfsResult > bestResultOne) {
                bestResultTwo = bestResultOne;
                bestResultOne = neighbourDfsResult;
            } else if (neighbourDfsResult > bestResultTwo) {
                bestResultTwo = neighbourDfsResult;
            }
        }

        //here i update the global max variable:
        max = Math.max(max, bestResultOne + bestResultTwo + 1);

        //here i return bestResultOne + 1 to calling function:
        return bestResultOne + 1;
    }
}


//                          0 'a'
//                         /  \
//                    'a' 2    1 'b'
//                       /     /  \
//                      5     3    4
//                     'e'   'c'   'b'

// so this problem demands dfs:
// i will first define the Adajecency list and character mapping hashmap:
// AL:
// [
//     0 -> [1,2],
//     1 -> [3,4],
//     2 -> [5]
// ]

// character mapping:
// [
//     0 -> 'a',
//     1 -> 'b',
//     2 -> 'a',
//     3 -> 'c',
//     4 -> 'b',
//     5 -> 'e'
// ]

// after that i will define a class level variable to track longest path so far:

// then i will start my dfs. dfs will get 0 as entry point, al, character mapping, and node 0s parent character lets say # maybe.

// then i enter dfs recursion method:
// not sure if i write the base case here?
// then i define bestNumebr1, bestNumber2.
// get nodes neighbours.

// loop on neighbour:
// if current neighbours character == parent charaacter then skip.
// other wise perform dfs on it pass neighbour, parents character, al and charzcter mappng.
// then i will get an int value, comapre against bestNumebr1 update that then update global variable.


