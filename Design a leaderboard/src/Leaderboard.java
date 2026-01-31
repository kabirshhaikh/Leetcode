import java.util.*;

public class Leaderboard {
    public class PlayerScore {
        int playerId;
        int score;

        PlayerScore(int playerId, int score) {
            this.playerId = playerId;
            this.score = score;
        }
    }

    HashMap<Integer, Integer> map;
    PriorityQueue<PlayerScore> pq;

    public Leaderboard() {
        map = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> b.score - a.score);
    }

    public void addScore(int playerId, int score) {
        int newScore = map.getOrDefault(playerId, 0) + score;
        map.put(playerId, newScore);
        pq.offer(new PlayerScore(playerId, newScore));
    }

    public int top(int K) {
        int sum = 0;
        List<PlayerScore> valid = new ArrayList<>();
        Set<Integer> usedPlayers = new HashSet<>();

        while (K > 0 && !pq.isEmpty()) {
            PlayerScore ps = pq.poll();

            if (ps != null && map.containsKey(ps.playerId) && map.get(ps.playerId) == ps.score
                    && !usedPlayers.contains(ps.playerId)) {
                sum += ps.score;
                valid.add(ps);
                usedPlayers.add(ps.playerId);
                K--;
            }

        }

        //now put the used objects back to pq to maintain leader score:
        for (int i = 0; i < valid.size(); i++) {
            pq.offer(valid.get(i));
        }

        return sum;
    }

    public void reset(int playerId) {
        map.remove(playerId);
    }
}