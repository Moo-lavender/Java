
/*
链接：https://www.nowcoder.com/questionTerminal/769d45d455fe40b385ba32f97e7bcded
来源：牛客网

根据输入的日期，计算是这一年的第几天。。

详细描述：

输入某年某月某日，判断这一天是这一年的第几天？。

输入描述:
输入三行，分别是年，月，日



输出描述:
成功:返回outDay输出计算后的第几天;
                                           失败:返回-1
*/
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            int [] Day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} ;
            if(judge(year)){
                Day[1] = 29;
            }
            int sum = 0;
            for(int i = 1; i < month; i ++){
                sum += (Day[i-1]);
            }
            sum += day;
            System.out.println(sum);
        }
    }
    public static boolean judge(int year) {
        if(year % 400 == 0) return true;
        if(year % 4 == 0 && year % 100 != 0) return true;
        return false;
    }
}