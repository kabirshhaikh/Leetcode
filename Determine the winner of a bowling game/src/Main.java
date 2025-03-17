public class Main {
    public static void main(String[] args) {
        int[] player1 = {5, 10, 3, 2};
        int[] player2 = {6, 5, 7, 3};
        int test = isWinner(player1, player2);
        System.out.println(test);
    }


    private static int isWinner(int[] player1, int[] player2) {
        int totalScoreOfPlayer1 = checkTotal(player1);
        int totalScoreOfPlayer2 = checkTotal(player2);

        if (totalScoreOfPlayer1 > totalScoreOfPlayer2) {
            return 1;
        } else if (totalScoreOfPlayer1 < totalScoreOfPlayer2) {
            return 2;
        } else {
            return 0;
        }
    }

    private static int checkTotal(int[] nums) {
        int total = 0;
        boolean wasPrevious10 = false;
        boolean wasTwoTurnsAgo10 = false;

        for (int i = 0; i < nums.length; i++) {
            int currentScore = nums[i];
            if (wasPrevious10 || wasTwoTurnsAgo10) {
                currentScore = currentScore * 2;
            }
            total = total + currentScore;
            wasTwoTurnsAgo10 = wasPrevious10;
            wasPrevious10 = (nums[i] == 10);
        }

        return total;
    }
}
