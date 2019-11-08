import java.util.*;
//给定一个数组和它的大小，判断这组数组有几个逆序对
public class AntiOrder {
    public int count(int[] A, int n) {
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(A[i] > A[j]){
                   count ++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,0};
        System.out.println(new AntiOrder().count(arr,arr.length));
    }
}