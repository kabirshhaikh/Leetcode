public class Main {
    public static void main (String[] args) {
        int[][] grid = {{1,1,0,0}, {0,0,1,0}, {0,0,1,0}, {0,0,0,1,}};
        int test = countServers(grid);
        System.out.println(test);
    }

    //1,1,0,0
    //0,0,1,0
    //0,0,1,0
    //0,0,0,1

    public static int countServers (int[][] grid) {
        int output = 0;

        int[] rowsCount = new int[grid.length];
        int[] colsCount = new int[grid[0].length];

        for (int i=0; i<grid.length; i++) {
            int[] current = grid[i];
            for (int j=0; j<current.length; j++) {
                if (current[j] == 1) {
                    rowsCount[i]++;
                    colsCount[j]++;
                }
            }
        }

        for (int i=0; i<grid.length; i++ ) {
            int[] current = grid[i];
            for (int j=0; j<current.length; j++) {
                if (current[j] == 1 && (rowsCount[i] > 1 || colsCount[j] > 1)) {
                    output++;
                }
            }
        }

        return output;
    }
}



//    public static int countServers (int[][] grid) {
//        int output = 0;
//
//        //Iterate over rows to check if there are more than one '1''s on same row:
//        for (int i=0; i<grid.length; i++) {
//            int onesOnSameRow = 0;
//            int[] current = grid[i];
//            for (int j=0; j<current.length; j++) {
//                if (current[j] == 1) {
//                    onesOnSameRow++;
//                }
//            }
//            if (onesOnSameRow >= 2) {
//                output = output + onesOnSameRow;
//            }
//        }
//
//        int row = grid.length;
//        int col = grid[0].length;
//
//        //Iterate over cols to check if there are more than one '1''s on same col:
//        for (int i=0; i<col; i++) {
//            int onesOnSameCol = 0;
//            for (int j=0; j<row; j++) {
//                if (grid[j][i] == 1) {
//                    onesOnSameCol++;
//                }
//            }
//            if (onesOnSameCol >= 2) {
//                output = output + onesOnSameCol;
//            }
//        }
//
//        return output;
//    }
