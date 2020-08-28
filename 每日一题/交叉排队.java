/*
美团2020测开笔试
一个班级男生和女生数量相同，老师要求男生女生进行排队，男生全部排在队列前面，女生紧跟着排在男生队列后面，形成一个队列，现在要求男生女生交叉排列并且第一位是男生，且每个人在在原队列中的顺序不变，如何来做？

 

要求：

交叉前：队列[男1，男2，男3，男4…男n，女1，女2，女3，女4…女n]

交叉后：队列[男1，女1，男2，女2，男3，女3，男4，女4…男n，女n]
*/
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] boy = new int[num];
        int[] gril = new int[num];
        for (int i = 0; i < num; i ++) {
            boy[i] = sc.nextInt();
        }
        for (int i = 0; i < num; i ++) {
            gril[i] = sc.nextInt();
        }
        int b = 0, g = 0;
        for (int i = 1; i < num*2+1; i ++) {
            if ((i & 1) == 1) {
                System.out.println(boy[b++]);
            }else{
                System.out.println(gril[g++]);
            }
        }
    }
}
