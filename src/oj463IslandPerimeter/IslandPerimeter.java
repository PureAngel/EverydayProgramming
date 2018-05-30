package oj463IslandPerimeter;

/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 *
 * Example:
 *
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * Answer: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 */

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if(grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int perimeter = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    perimeter += addPeri(grid,i + 1,j,row,col);
                    perimeter += addPeri(grid,i - 1,j,row,col);
                    perimeter += addPeri(grid,i,j + 1,row,col);
                    perimeter += addPeri(grid,i,j - 1,row,col);
                }
            }
        }
        return perimeter;
    }

    private int addPeri(int[][] grid, int r, int c, int row, int col) {
        int peri = 0;
        if(r >= row || c >= col || r < 0 || c < 0) {
            peri++;
        } else {
            if(grid[r][c] == 0) {
                peri++;
            }
        }
        return peri;
    }
}
