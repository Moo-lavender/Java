import java.util.Scanner;
/*
* 给定一个很长的DNA序列，以及要求的最小子序列长度
* 求CG 所占比例最高的子序列*/
public class DNAMaxCount {
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        String s = scanner.nextLine();
        int n = scanner.nextInt();
        char[] c = s.toCharArray();
        int maxCount = 0;
        int p = 0;
        int q = n;
        for(int i = 0; i < c.length - n; i++){
            int count = 0;
            for(int j = i; j < n + i; j++){
                if(c[j] == 'C' || c[j] == 'G'){
                    count ++;
                }
            }
            if(count > maxCount){
                maxCount = count;
                p = i;
                q = i + n;
            }
        }
        char[] ch = new char[n];
        for(int i = 0; i < n; i++,p++){
            ch[i] = c[p];
        }
        String result = new String(ch);
        System.out.println(result);
    }
}
