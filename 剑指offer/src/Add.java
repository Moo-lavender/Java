/*
不用加减运算做加法
思路：
相加通过异或实现
进位通过与门实现
*/
public class Add {
    public int add(int num1,int num2) {
        int result,ans;
        do {
            result = num1 ^ num2;
            ans = (num1 & num2) << 1;
            num1 = result;
            num2 = ans;
        }while(ans != 0);
        return result;
    }
}