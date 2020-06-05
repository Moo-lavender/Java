/*输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

 

示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        //先向右走，直到超过数组大小或者碰到已经遍历过的元素，向下走、向左走、向上走
        //直到都走不动，遍历结束.
        int[] res = {};
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] used = new boolean[row][col];
        res = new int[row * col];
        int i = 0,j = -1,p = 0;
        while (j+1 < col && !used[i][j+1]) {
            for (int m = 0; m < 4; m ++) {
                int newX = i + direction[m][0];
                int newY = j + direction[m][1];
                while (newX >= 0 && newX < row  && newY >= 0 && newY < col && !used[newX][newY]) {
                    res[p ++] = matrix[newX][newY];
                    used[newX][newY] = true;
                    i = newX;
                    j = newY; 
                    newX = i + direction[m][0];
                    newY = j + direction[m][1];
                }
                newX = i - direction[m][0];
                newY = j - direction[m][1];

            }
        }
        return res;
    }
}