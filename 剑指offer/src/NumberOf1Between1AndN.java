//可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
public class NumberOf1Between1AndN {
	//复杂度o（n*logN）
    public int NumberOf1Between1AndN1(int n) {
        int count = 0;
        for(int i = 0 ; i <= n; i++){
           for(int j = i; j > 0; j /= 10){
               if(j % 10 == 1){
                   count++;
               }
           }
        }
        return count;
    }
	
}