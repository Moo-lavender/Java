import java.util.*;

public class AvengeGPA{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int course = sc.nextInt();
            int[] credit = new int[course];
            int[] score = new int[course];
            double[] GPA = new double[course];
            double sumGPA = 0;
            double sumCredit = 0;
            for(int i = 0; i < course; i++){
                credit[i] = sc.nextInt();
                sumCredit += credit[i];
            }
            for(int i = 0; i < course; i++){
                score[i] = sc.nextInt();
            }
            for(int i = 0; i < course; i++){
                if(score[i] >= 90 && score[i] <= 100){
                    GPA[i] = 4.0 * credit[i];
                }
                if(score[i] >= 85 && score[i] <= 89){
                    GPA[i] = 3.7 * credit[i];
                }
                if(score[i] >= 82 && score[i] <= 84){
                    GPA[i] = 3.3 * credit[i];
                }
                if(score[i] >= 78 && score[i] <= 81){
                    GPA[i] = 3.0 * credit[i];
                }
                if(score[i] >= 75 && score[i] <= 77){
                    GPA[i] = 2.7 * credit[i];
                }
                if(score[i] >= 72 && score[i] <= 74){
                    GPA[i] = 2.3 * credit[i];
                }
                if(score[i] >= 68 && score[i] <= 71){
                    GPA[i] = 2.0 * credit[i];
                }
                if(score[i] >= 64 && score[i] <= 67){
                    GPA[i] = 1.5 * credit[i];
                }
                if(score[i] >= 60 && score[i] <= 63){
                    GPA[i] = 1.0 * credit[i];
                }
                if(score[i] >= 0 && score[i] < 60){
                    GPA[i] = 0 ;
                }
                sumGPA += GPA[i];
            }
            double resultGPA = sumGPA / (double)sumCredit;
            System.out.printf("%.2f",resultGPA);
        }
    }
}