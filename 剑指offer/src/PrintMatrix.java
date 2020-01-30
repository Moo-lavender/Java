/*
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下4 X 4矩阵：
 1  2  3  4 
 5  6  7  8 
 9  10 11 12 
 13 14 15 16 
 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
import java.util.ArrayList;
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
       //定义坐标变化位，分别为向右，向下，向左，向上
        int [] dx = {0,+1,0,-1};
        int [] dy = {+1,0,-1,0};
        //求出输入数组的长度
        int row = matrix.length;
        int col = matrix[0].length;
        //定义是否走过当前位置的标志,没走过为false
        boolean [][] flag = new boolean[row][col];
        //定义当前打印位置的行，列
        int x = 0, y = 0;
        //定义当前的方向dir，1，2，3，4分别为右、下、左、上
        int dir = 0;
        //开始循环，如果当前坐标不超出总行列数，且当前位置没有走过就循环
        while(x >= 0 && x < row && y >= 0 && y < col && !flag[x][y]){
            ans.add(matrix[x][y]);
            flag[x][y] = true;
            //嵌套循环，如果接下来要走的方向的坐标合法，则继续打印
            while(x + dx[dir] >= 0 && x + dx[dir] < row &&
                  y + dy[dir] >= 0 && y + dy[dir] < col && 
                  !flag[x+dx[dir]][y+dy[dir]]){
                x += dx[dir];
                y += dy[dir];
                ans.add(matrix[x][y]);
            }
            //出循环表示该方向已经走完，应该转换方向
            dir = (dir + 1) % 4;
            x += dx[dir];
            y += dy[dir];
        }
        //出循环则结束
        return ans;
    }
}





