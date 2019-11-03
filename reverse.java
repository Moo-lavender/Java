//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
//如果反转后整数溢出那么就返回 0。
class Reverse {
    public int reverse(int x) {
        long t = 0;
        while(x != 0){
        t =t * 10 + x % 10;
        x = x/10;
        }
       if((int)t == t){
           return (int)t;
       }else{
           return 0;
       }
    }
}