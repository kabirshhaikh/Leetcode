import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[][] pick = {{0,0}, {1,0}, {1,0}, {2,1}, {2,1}, {2,0}};
        int n = 4;
        int test = winningPlayerCount(n, pick);
        System.out.println(test);
    }


    private static int winningPlayerCount (int n, int[][] pick) {
        int winningPlayers = 0;

        HashMap<Integer, HashMap<Integer, Integer>> player = new HashMap<>();

        for (int i=0; i<pick.length; i++) {
            int[] current = pick[i];
            int currentPlayer = current[0];
            int color = current[1];

            player.putIfAbsent(currentPlayer, new HashMap<>());
            HashMap<Integer, Integer> colorAndCount = player.get(currentPlayer);
            colorAndCount.put(color, colorAndCount.getOrDefault(color, 0 ) + 1);
        }

        for (Map.Entry<Integer, HashMap<Integer, Integer>> map : player.entrySet()) {
            int playerId = map.getKey();
            HashMap<Integer, Integer>  colorAndCount = map.getValue();
            for (Map.Entry<Integer, Integer> colorAndCountMap : colorAndCount.entrySet()) {
                int countOfColor = colorAndCountMap.getValue();
                if (countOfColor >= playerId + 1) {
                    winningPlayers++;
                    break;
                }
            }
        }

        return winningPlayers;
    }
}
