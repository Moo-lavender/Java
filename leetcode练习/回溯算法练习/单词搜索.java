/*
79. 单词搜索
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false*/
class Solution {
    private boolean[][] used;
    private int[][] direction = {{-1,0},{0,-1},{0,1},{1,0}};
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        
        int m = board.length;
        int n = board[0].length;
        used = new boolean[m][n];

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (back(i,j,0,board,word)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean back(int row,int col,int index,char[][] board, String word) {
        char c = word.charAt(index);
        if (index == word.length() - 1) {
            return (c == board[row][col]);
        }
        int m = board.length;
        int n = board[0].length;
        if (board[row][col] == c) {
            used[row][col] = true;
            for (int i = 0; i < 4; i ++) {
                int newX = row + direction[i][0];
                int newY = col + direction[i][1];
                 if (newX >= 0 && newX < m && newY >= 0 && newY < n && !used[newX][newY]){
                     if (back(newX,newY,index + 1,board,word)) {
                         return true;
                     }
                 }
            }
            used[row][col] = false;
        }
        return false;

    }
}