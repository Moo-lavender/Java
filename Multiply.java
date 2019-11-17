
//给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
// 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
public class Multiply {
    public int[] multiply1(int[] A) {
        int[] B = new int[A.length];
        int sum1 = 1;
        int sum2 = 1;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < i; j++){
                sum1 = sum1 * A[j];
            }
            for(int j = i + 1; j < A.length;j ++){
                sum2 = sum2 * A[j];
            }
            B[i] = sum1 * sum2;
            sum1 = 1;
            sum2 = 1;
        }
        return B;
    }
    public int[] multiply2(int[] A){
        if (A == null){
            return null;
        }
        int[] B = new int[A.length];
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        left[0] = 1;
        right[A.length - 1] = 1;
        for(int i = 0; i < A.length; i ++){
            left[i] = A[i - 1] * left[i - 1];
        }
        for(int i = A.length - 2; i > 0; i --){
            right[i] = right[i + 1] * A[i + 1];
        }
        for(int i = 0; i < A.length; i ++){
            B[i] = left[i] + right[i];
        }
        return B;
    }
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,4,5};
    }
}