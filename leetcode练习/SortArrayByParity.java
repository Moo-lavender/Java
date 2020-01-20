/*
* 给定一个非负整数数组 A，返回一个数组，在该数组中，
*  A 的所有偶数元素之后跟着所有奇数元素。
*/
//使用双指针法
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int isOushu = A.length - 1;
        int isJishu = 0;
        while(isJishu < isOushu){
            if(A[isJishu] %2 == 0){
                isJishu ++;
            }else if(A[isOushu] %2 != 0){
                isOushu --;
            }else{
                int tmp = A[isJishu];
                A[isJishu] = A[isOushu];
                A[isOushu] = tmp;
            }
        }
        return A;
    }
}