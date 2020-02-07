/*
统计一个数字在排序数组中出现的次数。
1.二分法
2.遍历
3.遍历加条件判断
*/
public class GetNumberOfK {
	public int GetNumberOfK1(int [] array , int k) {
        if (array == null || array.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < array.length; i ++) {
            if (array[i] == k) {
                count ++;
            }
        }
        return count;
    }
	public int GetNumberOfK3(int [] array , int k) {
        if (array == null || array.length == 0) return 0;
        int count = 0;
        int flag = 0;
        for (int i = 0; i < array.length; i ++) {
            if (array[i] == k) {
                count ++;
                flag = 1;
            }else if(flag == 1) {
                break;
            }
        }
        return count;
    }
    public int getNumberOfK2(int [] array , int k) {
        if(array == null || array.length == 0) return 0;
        int count = 0;
        int mid = array.length - 1 / 2;
        int left = 0; 
        int right = array.length - 1;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (array[mid] == k) {
                break;
            }else if (array[mid] > k){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
            if(right == left) {
            return 0;
            }
        }
        if (mid == array.length) {
            if(array[mid - 1] == k){
                return 1;
            }else{
                return 0;
            }
        }
        int i = mid;
        int j = mid;
        boolean pi = true;
        boolean pj = true;
        while(pi || pj) {
            if (pi && i >= 0 && array[i] == k) {
                count ++;
                i--;
            }else {
                pi = false;
            }
            if (pj && j < array.length && array[j] == k ) {
                count ++;
                j++;
            }else {
                pj = false;
            }
        }
        return count - 1;
    }
}