/*
写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception{
       Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            System.out.println(Integer.decode(str));
        }
    }
}