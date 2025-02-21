public class Main {
    public static void main (String[] args) {
        int[][] grid = {{0,0,1}, {1,0,1}, {0,0,0}};
        int test = findChampion(grid);
        System.out.println(test);
    }

    private static int findChampion (int[][] grid) {
        int indexOfChampionTeam = 0;
        int countOfMaxOnes = Integer.MIN_VALUE;

        for (int i=0; i<grid.length; i++) {
            int countOfOnes = 0;
            int[] current = grid[i];
            for (int j=0; j<current.length; j++) {
                if (current[j] == 1) {
                    countOfOnes++;
                }
            }
            if (countOfOnes > countOfMaxOnes) {
                countOfMaxOnes = countOfOnes;
                indexOfChampionTeam = i;
            }
        }

        return indexOfChampionTeam;
    }
}
