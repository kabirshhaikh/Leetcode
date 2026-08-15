import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        int[][] grid = {{1,0}, {0,1}};
        int output = largestIsland(grid);
        System.out.println(output);
    }

    public static int largestIsland(int[][] grid) {
        //here i define a hashmap to store key as address and its neighbours count as value:
        HashMap<Integer, Integer> map = new HashMap<>();

        //max variable for output:
        int max = -1;

        //here i define a variable called address which will be used to group neighbouring cells:
        int address = 2;

        //now i run a loop over grid and check cells, wherever i find 1, i then run a dfs on it:
        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    int neighbourCount = dfs(grid, address, row, col);
                    map.put(address, neighbourCount);
                    address++;
                }
            }
        }

        //doing this ensures that when we run phase two and if we dont find any cell with val 0 then i returns the address which has most number of neighbours:
        for (int size : map.values()) {
            max = Math.max(max, size);
        }

        //now i run the phase two:
        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[row].length; col++) {
                //so when a 0 cell is detected i define a hashset to hold distinct address neighbours:
                //i also define a total varible with 1 meaning current cell already flipped to 1:
                if (grid[row][col] == 0) {
                    HashSet<Integer> set = new HashSet<>();
                    int total = 1;

                    //now i check boundary:
                    //if it passes the boundary check then i add up down left and right cell to the hashset:
                    //up:
                    int upRow = row - 1;
                    int upCol = col;

                    if (upRow >= 0 && upRow < grid.length && upCol >= 0 && upCol < grid[upRow].length) {
                        if (grid[upRow][upCol] != 0) {
                            set.add(grid[upRow][upCol]);
                        }
                    }

                    //down:
                    int downRow = row + 1;
                    int downCol = col;

                    if (downRow >= 0 && downRow < grid.length && downCol >= 0 && downCol < grid[downRow].length) {
                        if (grid[downRow][downCol] != 0) {
                            set.add(grid[downRow][downCol]);
                        }
                    }

                    //left:
                    int leftRow = row;
                    int leftCol = col - 1;

                    if (leftRow >= 0 && leftRow < grid.length && leftCol >= 0 && leftCol < grid[leftRow].length) {
                        if (grid[leftRow][leftCol] != 0) {
                            set.add(grid[leftRow][leftCol]);
                        }
                    }

                    //right:
                    int rightRow = row;
                    int rightCol = col + 1;

                    if (rightRow >= 0 && rightRow < grid.length && rightCol >= 0 && rightCol < grid[rightRow].length) {
                        if (grid[rightRow][rightCol] != 0) {
                            set.add(grid[rightRow][rightCol]);
                        }
                    }

                    //once done i loop over the hashset and get the value for that address and add it to total:
                    for (int id : set) {
                        total += map.get(id);
                    }

                    //after doing above steps i update the max variable:
                    max = Math.max(max, total);
                }
            }
        }

        //in the end i return max:
        return max;
    }

    //so this is my helper dfs function:
    public static int dfs (int[][] grid, int address, int row, int col) {
        //base case 1: boundary check:
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length) {
            return 0;
        }

        //second base case: if current cell is not 1:
        if (grid[row][col] != 1) {
            return 0;
        }

        //otherwise mark current cell as address:
        grid[row][col] = address;

        //now perform recursion on up down left and right:
        int up = dfs(grid, address, row - 1, col);

        int down = dfs(grid, address, row + 1, col);

        int left = dfs(grid, address, row, col - 1);

        int right = dfs(grid, address, row, col + 1);

        //in the end i return 1 + up + down + left + right:
        return 1 + up + down + left + right;
    }
}



//so i will solve the problem in two phases:
//phase 1:
//here i will define a map which will hold key -> address and value as how many neighbours it has bascially depth:
//then i will define int max = Integer.MIN_VALUE;

//here i will run dfs on the grid:
//the algo will be something like this:
//i will define a variable called address and set it to 2 (it can be any number but 2).
//then i will run a loop on the grid and detect cell with val 1.
//no I will run dfs (return type int) (params -> grid, the address variable) on it:
//base case is simple, two base cases first check boundary rows and cols return 0.
//second base case: if grid[row][col] != 1 then return 0.
//set current grid[row][col] = address.
//then run recursion on up down left and right.
//doing this will mark all connecting islands with same address.
//then after performing recursion i will return  1 + up + down + left + right.
//then in the for loop after performing the dfs i will store the address as key and value returned by the dfs as value in the hashmap.
//then i will increment the address counter.

//now phase two:
//then i will run a loop on grid again.
//i will check for cell with val 0.
//then i will define a hashset to hold neighbours address.
//so once 0 is detected I will do boundary check for up down left and right.
//then i will add only the neighbours to hashset which is cell value other than 0.
//then i will loop over the hashset and get count of each address, sum that and check it against max and update max.

//in the end i will return max;

//original:
//1 0
//0 1

//after performing above steps of phase 1:
//2 1
//0 3
