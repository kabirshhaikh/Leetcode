public class Main {
    public static void main (String[] args) {
        int[][] grid = {{4,3,2,-1}, {3,2,1,-1}, {1,1,-1,-2}, {-1,-1,-2,-3}};
        countNegatievs(grid);
    }

    public static int countNegatievs (int[][] grid) {
        int count = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    count = count + 1;
                }
            }
        }
        System.out.println("Count:" +count);
        return count;
    }

}
