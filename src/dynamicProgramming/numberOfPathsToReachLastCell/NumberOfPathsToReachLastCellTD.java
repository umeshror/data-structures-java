package dynamicProgramming.numberOfPathsToReachLastCell;
/*
 * We are given a 2D matrix
 * Accessing each cell have a. Cost associated with it
 * We need. To start from (0,0) cell and go till (n-1, n-1) cell
 * We are given total cost to reach end of array
 * We can go only right or down cell from current cell
 * Challenge is to find the number of ways to reach end of matrix with given ’total cost'
 */

public class NumberOfPathsToReachLastCellTD {

    public int numberOfPaths(int array[][], int row, int col, int cost) {
        int[][] dp = new int[row + 1][col + 1];
        return numberOfPathsAux(dp, array, row, col, cost);
    }


    public int numberOfPathsAux(int dp[][], int array[][], int row, int col, int cost) {
        if (cost < 0) {// BASE CASE
            return 0;
        }
        if (row == 0 && col == 0) { // BASE CASE
            return (array[0][0] - cost == 0) ? 1 : 0;
        }
        if (dp[row][col] == 0) {// If we have not solved this problem previously, only then solve it
            if (row == 0) { // BASE CASE: If we're at first row, we can only go left
                dp[row][col] = numberOfPaths(array, 0, col - 1, cost - array[row][col]);
            } else if (col == 0) { // BASE CASE: if we're at first column, we can only go up
                dp[row][col] = numberOfPaths(array, row - 1, 0, cost - array[row][col]);
            } else {
                int noOfPathsFromPreviousRow = numberOfPaths(array, row - 1, col, cost - array[row][col]); // Find Paths till last Row
                int noOfPathsFromPreviousCol = numberOfPaths(array, row, col - 1, cost - array[row][col]); // Find Paths till last Col
                dp[row][col] = noOfPathsFromPreviousRow + noOfPathsFromPreviousCol;
            }
        }
        return dp[row][col];
    }


    public static void main(String[] args) {
        int[][] array = {
                {4, 7, 1, 6},
                {5, 7, 3, 9},
                {3, 2, 1, 2},
                {7, 1, 6, 3}};
        int cost = 25;
        
        NumberOfPathsToReachLastCellTD nop = new NumberOfPathsToReachLastCellTD();
        System.out.println("Total paths with cost " + cost + " are " + nop.numberOfPaths(array, array.length - 1, array[0].length - 1, cost));
    }
}






