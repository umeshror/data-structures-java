package divideConquer.minCostToReachLastCellIIn2DArray;
/*
 * We are given a 2D matrix
 * Accessing each cell have a. Cost associated with it
 * We need. To start from (0,0) cell and go till (n-1, n-1) cell
 * We can go only right or down cell from current cell
 * Challange is to do the traversal in minimum cos
 */
public class MinCostToReachLastCellIIn2DArray {
    public int findMinCost(int[][] cost, int row, int col) {
        if (row == -1 || col == -1) {  //BASE CASE
            return Integer.MAX_VALUE;
        }
        if (row == 0 && col == 0) { //BASE CASE: If we're at first cell (0, 0),then no need to recurse
            return cost[0][0];
        }
        int minCost1 = findMinCost(cost, row - 1, col);//Case#1 Get min cost if we go 'up' from current cell
        int minCost2 = findMinCost(cost, row, col - 1);//Case#2 Get min cost if we go 'left' from current cell
        int minCost = Integer.min(minCost1, minCost2);
        int currentCellsCost = cost[row][col];
        return minCost + currentCellsCost;
    }


    public static void main(String[] args) {
        int[][] array =
                {
                        {4, 7, 8, 6, 4},
                        {6, 7, 3, 9, 2},
                        {3, 8, 1, 2, 4},
                        {7, 1, 7, 3, 7},
                        {2, 9, 8, 9, 3}
                };
        MinCostToReachLastCellIIn2DArray mctrlc = new MinCostToReachLastCellIIn2DArray();
        System.out.print("The minimum cost is " + mctrlc.findMinCost(array, array.length - 1, array[0].length - 1));
    }
}