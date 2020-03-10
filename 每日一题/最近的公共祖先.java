/*
链接：https://www.nowcoder.com/questionTerminal/70e00e490b454006976c1fdf47f155d9
来源：牛客网

有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号，根结点编号为1。
现在有两个结点a，b。请设计一个算法，求出a和b点的最近公共祖先的编号。

给定两个int a,b。为给定结点的编号。请返回a和b的最近公共祖先的编号。
注意这里结点本身也可认为是其祖先。
*/
import java.util.*;

public class LCA {
    public int getLCA(int a, int b) {
        while(a != b){
            a = a > b ? a >> 1 : a;
            b = b > a ? b >> 1 : b;
        }
        return a;
    }
}