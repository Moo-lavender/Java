/*
* 读入N名学生的成绩，将获得某一给定分数的学生人数输出。
* 第1行：N
* 第2行：N名学生的成绩，相邻两数字用一个空格间隔。
* 第3行：给定分数
* 当读到N=0时输入结束。其中N不超过1000，成绩分数为（包含）0到100之间的一个整数。
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountSameScore {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n == 0){
                break;
            }
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                list.add(sc.nextInt());
            }
            int t = sc.nextInt();
            int count = 0;
            for(int a:list){
                if(a == t){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
