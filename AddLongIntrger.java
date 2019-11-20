import java.util.Scanner;

public class AddLongIntrger {
     public static void main(String [] args){
         Scanner scanner = new Scanner(System.in);
         String a = scanner.nextLine();
         String b = scanner.nextLine();
         System.out.println(new AddLongIntrger().AddLongIntrger(a,b));
 }
    public String AddLongIntrger(String addend,String augend){
         char[] a = addend.toCharArray();
         char[] b = augend.toCharArray();
         int cha = 0;
         int maxBit = a.length > b.length ? a.length: b.length;
         int minBit = a.length < b.length ? a.length: b.length;
         char[] r = new char[maxBit + 1];
         char[] big ;
         char[] small ;
         String s;
         if(a.length >= b.length){
              cha = a.length - b.length;
              big = a;
              small = b;
         }else{
             cha = b.length - a.length;
             big = b;
             small = a;
         }
         int p = 0;//进位
         for(int i = 0; i < minBit; i++){
             int x = (int)(big[maxBit - i -1] - 48);
             int y = (int)(small[minBit - i -1] - 48);
             int z = x + y + p;
             char c = (char) (z + '0');
             if(z < 10){
                 r[maxBit - i - 1] = c;
                 p = 0;
             }else{
                 r[maxBit - i - 1] = (char)((z - 10) + '0');
                 p = 1;
             }
         }
         for(int i = maxBit - minBit - 1 ; i >= 0; i --){
             if( p == 1){
                 if((int)(big[i] - 48) + p < 10 ){
                     r[i] = (char)((int)(big[i]- 48 + 1) + '0');
                     p = 0;
                 }else{
                     r[i] = (char)(((int)(big[i]-48)) - 9 + '0');
                     p = 1;
                 }
             }else{
                 r[i] = big[i];
             }
         }
         if( p == 0){
             s = new String(r);
         }else{
             s = "1" + new String(r);
         }
         return s;
    }
}

