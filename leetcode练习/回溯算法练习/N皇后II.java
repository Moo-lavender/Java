/*
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回 n 皇后不同的解决方案的数量。

示例:

输入: 4
输出: 2
解释: 4 皇后问题存在如下两个不同的解法。
[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    int num = 0;
    int[][] board;
    public int totalNQueens(int n) {
        if (n == 0) return 0;
        board = new int[n][n];
        back (0);
        System.out.println(num);
        return num;

    }
    private void back(int row) {
        if (row == board.length) {
            num ++;
            return;
        }

        for (int col = 0; col < board.length; col ++) {
            if (! isValid(row,col)) continue;
            board[row][col] = 1;
            back(row + 1);
            board[row][col] = 0;
        }
    } 
    private boolean isValid(int row,int col) {
        for (int i = 0; i < row; i ++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        for (int i = row-1,j = col-1; i>= 0 && j >= 0; i --,j --) {
            if (board[i][j] == 1) {
                return false;
            }
        } 
        for (int i = row-1,j = col+1; i >= 0 && j < board.length;i --,j ++ ) {
            if (board[i][j] == 1) {
                return  false;
            }
        }
        return true;
    }
}