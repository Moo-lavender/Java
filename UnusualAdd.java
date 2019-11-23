//编写一个函数将两个数字相加，不得使用+或者其它算术运算符
public class UnusualAdd {
    public int addAB(int A, int B) {
        int xor,and;
        while(B!=0){
            xor = A^B;
            and = (A&B)<<1;
            A=xor;
            B=and;
        }
        return A;
    }
    public static void main(String[] args) {
        int a = 8;
        int b = 10;
        System.out.println(new UnusualAdd().addAB(a,b));
    }
}
