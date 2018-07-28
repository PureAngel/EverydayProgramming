package oj661ImageSmoother;

/**
 * Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.
 *
 * Example 1:
 * Input:
 *  [[1,1,1],
 *  [1,0,1],
 *  [1,1,1]]
 * Output:
 * [[0, 0, 0],
 *  [0, 0, 0],
 *  [0, 0, 0]]
 * Explanation:
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * Note:
 * The value in the given matrix is in the range of [0, 255].
 * The length and width of the given matrix are in the range of [1, 150].
 */

public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        if(M.length == 0 || M[0].length == 0) {
            return M;
        }
        int row = M.length, col = M[0].length;
        int[][] res = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int count = 0;
                for(int nr = i - 1; nr <= i + 1; nr++) {
                    for(int nc = j - 1; nc <= j + 1; nc++) {
                        if(nr >= 0 && nr < row && nc >= 0 && nc < col) {
                            res[i][j] += M[nr][nc];
                            count++;
                        }
                    }
                }
                res[i][j] /= count;
//                if(i > 0 && i < row - 1) {
//                    if(j > 0 && j < col - 1) {
//                        res[i][j] = (M[i - 1][j - 1] + M[i - 1][j] + M[i - 1][j + 1]
//                                + M[i][j - 1] + M[i][j] + M[i][j + 1]
//                                + M[i + 1][j - 1] + M[i + 1][j] + M[i + 1][j]) / 9;
//                    } else if(j == 0) {
//                        if(j + 1 < col) {
//                            res[i][j] = (M[i - 1][j] + M[i - 1][j + 1] + M[i][j] + M[i][j + 1] + M[i + 1][j] + M[i + 1][j + 1]) / 6;
//                        } else {
//                            res[i][j] = (M[i - 1][j] + M[i][j] + M[i + 1][j]) / 3;
//                        }
//                    } else {
//                        res[i][j] = (M[i - 1][j - 1] + M[i - 1][j] + M[i][j - 1] + M[i][j] + M[i + 1][j - 1] + M[i + 1][j]) / 6;
//                    }
//                } else if(i == 0) {
//                    if(j > 0 && j < col - 1) {
//                        if(i + 1 < row) {
//                            res[i][j] = (M[i][j - 1] + M[i][j] + M[i][j + 1] + M[i + 1][j - 1] + M[i + 1][j] + M[i + 1][j + 1]) / 6;
//                        } else {
//                            res[i][j] = (M[i][j - 1] + M[i][j] + M[i][j + 1]) / 3;
//                        }
//                    } else if(j == 0) {
//                        if(j + 1 < col) {
//                            if(i + 1 < row) {
//                                res[i][j] = (M[i][j] + M[i][j + 1] + M[i + 1][j] + M[i + 1][j + 1]) / 4;
//                            } else {
//                                res[i][j] = (M[i][j] + M[i][j + 1]) / 2;
//                            }
//                        } else {
//                            if(i + 1 < row) {
//                                res[i][j] = (M[i][j] + M[i + 1][j]) / 2;
//                            } else {
//                                res[i][j] = M[i][j];
//                            }
//                        }
//                    } else { // i == 0 && j == col - 1 && j > 0
//                        if(i + 1 < row) {
//                            res[i][j] = (M[i][j - 1] + M[i][j] + M[i + 1][j - 1] + M[i + 1][j]) / 4;
//                        } else {
//                            res[i][j] = (M[i][j - 1] + M[i][j]) / 2;
//                        }
//                    }
//                } else { // i == row - 1 && i > 0
//                    if(j > 0 && j < col - 1) {
//                        res[i][j] = (M[i - 1][j - 1] + M[i - 1][j] + M[i - 1][j + 1] + M[i][j - 1] + M[i][j] + M[i][j + 1]) / 6;
//                    } else if(j == 0) {
//                        if(j + 1 < col) {
//                            res[i][j] = (M[i - 1][j] + M[i - 1][j + 1] + M[i][j] + M[i][j + 1]) / 4;
//                        } else {
//                            res[i][j] = (M[i - 1][j] + M[i][j]) / 2;
//                        }
//                    } else { // j == col - 1 && j > 0
//                        res[i][j] = (M[i - 1][j - 1] + M[i - 1][j] + M[i][j - 1] + M[i][j]) / 4;
//                    }
//                }
            }
        }
        return res;
    }
}
