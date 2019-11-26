/*
*
一个百万富翁遇到一个陌生人，陌生人找他谈了一个换钱的计划。
* 该计划如下：我每天给你10 万元，你第一天给我1 分钱，第二天2 分钱，
第三天4 分钱……
这样交换 30 天后，百万富翁交出了多少钱？陌生人交出了多少钱？*/
public class MoneyExchange {
    public static void main(String[] args){
        int  millionaire = 10 * 30;
        int stranger= 1;
        int s = 1;
        for(int  i = 1; i < 30; i ++){
            s  = s * 2;
            stranger += s;
        }
        System.out.print(millionaire + " " + stranger);
    }
}
