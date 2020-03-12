/*
链接：https://www.nowcoder.com/questionTerminal/6fadc1dac83a443c9434f350a5803b51
来源：牛客网

有一个二维数组(n*n),写程序实现从右上角到左下角沿主对角线方向打印。

给定一个二位数组arr及题目中的参数n，请返回结果数组。

测试样例：
[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]],4
返回：[4,3,8,2,7,12,1,6,11,16,5,10,15,9,14,13]
*/
import java.util.*;

public class Printer {
    public int[] arrayPrint(int[][] arr, int n) {
        int[]ans = new int[n*n];
        int index = 0;
        int rowSart = 0;
        int colSart = n - 1;
        while(rowSart < n) {
            int x = rowSart;
            int y = colSart;
            while(x < n && y < n) {
                ans[index ++] = arr[x++][y++];
            }
            if(colSart > 0)
                colSart --;
            else
                rowSart ++;
        }
        return ans;
    }
}