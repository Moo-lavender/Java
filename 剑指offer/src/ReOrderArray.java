/*
调整数组顺序使得奇数位于偶数前面
*/
public class ReOrderArray {
    public void reOrderArray(int [] array) {
        if(array==null || array.length ==0){
            return ;
        }
        int m = 0;
        for(int i=0;i<array.length;i++){
            if((Math.abs(array[i]))%2!=0){
                int tmp = array[i];
                int j=i;
                while(j>m){
                    array[j] = array[j-1];
                    j--;
                }
                m=j+1;
                array[j] = tmp;
            }
        }
    }
}