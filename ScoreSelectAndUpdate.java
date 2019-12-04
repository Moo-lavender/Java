import java.util.Scanner;
/*
输入包括多组测试数据。
每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
学生ID编号从1编到N。
第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候,
表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
对于每一次询问操作，在一行里面输出最高成绩.*/
public class ScoreSelectAndUpdate {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int studentNum = sc.nextInt();
            int statementNum = sc.nextInt();
            int[] studentScore = new int[studentNum];
            for (int i = 0; i < studentNum; i++) {
                studentScore[i] = sc.nextInt();
            }
            for(int i = 0; i < statementNum ; i++){
                String s = sc.next();
                int a = sc.nextInt();
                int b = sc.nextInt();
                if(s .equals("Q")){
                    if(a > b){
                        int t = a;
                        a = b;
                        b = t;
                    }
                    int max = studentScore[a - 1];
                    for(int j = a - 1;j <= b - 1; j++){
                        if(max < studentScore[j]){
                            max = studentScore[j];
                        }
                    }
                    System.out.println(max);
                }else if(s .equals("U")){
                    studentScore[a - 1] = b;
                }
            }
        }
    }
}

