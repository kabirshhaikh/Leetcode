import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();

        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(new ArrayList<>());

        boolean ans = canVisitAllRooms(rooms);
        System.out.println(ans);
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //here i create the visited set:
        HashSet<Integer> visited = new HashSet<>();

        //i start the dfs with 0:
        dfs(0, rooms, visited);
        return visited.size() == rooms.size();
    }

    public static void dfs(int room, List<List<Integer>> rooms, HashSet<Integer> visited) {
        //mark the current room as visited:

        visited.add(room);
        //get the list of keys for the rooms:
        List<Integer> roomList = rooms.get(room);

        //here i write for loop to visited unvisited rooms and then dfs on them:
        for (int i = 0; i < roomList.size(); i++) {
            if (!visited.contains(roomList.get(i))) {
                dfs(roomList.get(i), rooms, visited);
            }
        }
    }
}

// dfs(0) retured back and at this point visited = {0,1,2,3}

// visited(0)
// list = {1}
// for:
// 1 not visited:

// dfs(1) return to dfs 0
// visited(0,1)
// list = {2}
// for:
// 2 not visited:

// dfs(2): return to dfs 1
// visited = {0,1,2}
// list = {3}
// for:
// 3 not visited:

// dfs(3):
// visited = {0,1,2,3}
// list = {}
// not for loop
// returns to dfs 2
