import java.util.Scanner;

/*
* 有一只兔子，从出生后第3个月起每个月都生一只兔子，
* 小兔子长到第三个月后每个月又生一只兔子，
* 假如兔子都不死，问每个月的兔子总数为多少？
*
* 关键是找到递推式 f(n)=f(n-1)+f(n-2) (n>=4)
* 递推式的解释:对于第n个月的兔子数量：有两部分组成，
* 一部分是上个月的兔子f(n-1)，另一部是满足3个月大的兔子
* 会生一只兔子f(n-2)*/
public class GetRabbitCount {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int monthCount = in.nextInt();
            System.out.println(getTotalCount(monthCount));
        }
    }
    public static int getTotalCount(int monthCount){
        if(monthCount==1 || monthCount==2){
            return 1;
        }

        return getTotalCount(monthCount-1)+getTotalCount(monthCount-2);
    }
}
