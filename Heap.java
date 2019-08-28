public class Heap {
    //向下调整（堆化）
    public static void heapify(int[] array,int size,int index){
        while(true) {
            int left = 2 * index + 1;
            if (left > size) {
                return;
            }
            int max = left;
            if (left + 1 < size && array[left + 1] > array[left]) {
                max = left + 1;
            }
            if (array[index] >= array[max]) {
                return;
            }
            swap(array, index, max);
            index = max;
        }
    }
    private static  void swap(int[] array,int p, int q){
         int t = array[p];
         array[p] = array[q];
         array[q] = t;
    }
    //建堆，任意数组转成堆 时间复杂度 log（n）
    public static  void ccreatHeap(int[] array,int size){
        for(int i = (size-2)/2; i >= 0; i--){
            heapify(array,size,i);
        }
    }
    //向上调整O(logn)
    public static void adjustUp(int[] array,int index){
        while(index > 0) {
            int parent = (index - 1) / 2;
            if (array[parent] < array[index]) {
                swap(array, index, parent);
                index = parent;
            }
            else{
                return;
            }
        }
    }


}

















