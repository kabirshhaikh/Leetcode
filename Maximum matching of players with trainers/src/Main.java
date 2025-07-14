import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] players = {4, 7, 9};
        int[] trainers = {8, 2, 5, 8};
        int test = matchPlayersAndTrainers(players, trainers);
        System.out.println(test);
    }

    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0;
        int j = 0;
        int match = 0;

        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                match++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return match;
    }

}
