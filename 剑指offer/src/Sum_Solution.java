//求1+2+3+...+n，要求不能使用乘除法、
//for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
//运用等差数列求和公式s=（n（n+1））/2
public class Sum_Solution {
    public int sum(int n) {
        return ((int)Math.pow(n,2) + n) >> 1;
    }
}