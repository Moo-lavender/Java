/*
某小红薯在小红书的活动中抽奖中了一定价值的薯券，这些薯券可以用来购买一批商品，求有多少种购买组合。其中一件商品可以买多件。
输 入:薯券金额、商品分别价格
输出 :组合数

输入描述:
输入薯券金额、商品分别价格
例如：10 [2,3,5]
10与[2,3,5]中间有空格

输出描述:
输出4，则结果集可以为:2,2,2,2,2；5,5；2,3,5；2,2,3,3共有4种组合 

输入例子1:
10 [2,3,5]

输出例子1:
4
*/

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        
        int res = backtrace(key,0,0,list,0);
        System.out.println(res);
    }
    private static int backtrace(int key,int index,int sum,ArrayList<Integer> list,int tmp) {
        if (sum > key) {
            return tmp;
        }
        if (sum == key) {
            tmp ++;
            return tmp;
        }
        
        for (int i = index; i < list.size(); i ++) {
            sum += list.get(i);
            backtrace(key,i,sum,list,tmp);
            sum -= list.get(i);
        }
        return tmp;
    } 
}