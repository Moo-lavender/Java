import java.util.Arrays;
import java.util.Stack;

public class Sort {
    //直接插入排序
    public void insertSort (int[] arr) {
        for(int i = 0; i < arr.length - 1 ; i ++) {
            int key = arr[i + 1];
            int j;
            for( j = i; j > 0 && arr[j] > key; j --) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
        }
    }
    //冒泡
    public void bubbleSort (int[] arr) {
        for(int i = 0; i < arr.length - 1; i ++) {
            for(int j = 0; j < arr.length - i - 1; j ++) {
                if(arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    //希尔排序
    public void insertSortWithGap(int[] arr, int gap) {
        for(int i = 0; i < arr.length - gap; i ++) {
            int key = arr[i + gap];
            int j;
            for(j = i; j >= 0 && arr[j] > key; j -= gap) {
                arr[j + gap] = arr[j];
            }
            arr[j] = key;
        }
    }
    public void shellSort(int[] arr){
        int gap = arr.length;
        while(true) {
            gap = gap / 3 + 1;
            insertSortWithGap(arr,gap);
            if(gap == 1) {
                return;
            }
        }
    }

    //选择排序
    public void selectSort(int[] arr) {
        for(int i = 0; i < arr.length ; i ++) {
            int max = 0;
            for(int j = 0; j < arr.length - i; j ++){
                if(arr[j] >= arr[max]) {
                    max = j;
                }
            }
            //交换
            int tmp = arr[arr.length - i - 1];
            arr[arr.length - 1 -i] = arr[max];
            arr[max] = tmp;
        }
    }
    public void selectSort2(int[] arr) {
        //有序区间 [0,i)
        //无序区间 [i ,length - 1]
        for(int i = 0; i < arr.length - 1; i ++) {
            int min = i;
            //选出待排序区间内最小的值
            for(int j = i + 1; j < arr.length ; j ++){
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            //交换
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }

    //堆排序
    public void heapSort(int[] arr) {
        for(int i = arr.length - 1; i > 0; i --) {
            heapify(arr, i);
            //交换堆顶元素
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
        }
    }
    public void heapify(int[] arr,int n) {
        int child;//表示左右节点中较大的节点的下标
        //i表示第一个非叶子节点的节点的下标
        for( int i = (n - 1)/2 ; i >= 0; i --) {
            child = 2 * i + 1;//左子节点位置
            //右子树存在且大于左子树节点，child就变成右节点
            if (child < n && arr[child] < arr[child + 1]) {
                child ++;
            }
            //根节点如果小于子节点则交换
            if(arr[i] < arr[child]) {
                int tmp = arr[child];
                arr[child] = arr[i];
                arr[i] = tmp;
            }
        }
    }
    private void heapSort2 (int[] arr){
        for(int i = arr.length - 1; i > 0; i --){
            for(int j = (i - 1)/2 ; j >= 0; j --) {
                int max;
                int left = 2 * j + 1;
                int right = left + 1;
                if(right > i || arr[right] < arr[left]){
                    max = left;
                }else {
                    max = right;
                }
                if(arr[j] < arr[max]){
                    int tmp = arr[j];
                    arr[j] = arr[max];
                    arr[max] = tmp;
                }
            }
            int tmp = arr[i];
             arr[i] = arr[0];
             arr[0] = tmp;
        }
    }

    //快排
    public void quickSort(int[] arr) {
        quickSortInternal(arr, 0, arr.length -1);
    }

    public void swap(int[] arr, int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    private void quickSortInternal(int[] arr, int left, int right) {
        if(left >= right) return;
        //1.确定基准值arr[right]作为基准值
        //2.遍历，小的左，大的右
        int pivotIndex = partition2(arr,left,right);
        //此时pivotIndex处的元素已经找到了自己的位置
        //以pivotIndex为基准值分成两个小区间，它是分区的下标指引
        //[left,pivotIndex-1]
        //[pivotIndex+1,right]
        quickSortInternal(arr,left,pivotIndex - 1);
        quickSortInternal(arr,pivotIndex + 1,right);
    }

    private int partition1(int[] arr, int left, int right) {
        int pivot = arr[right]; //以最右边的数字为基准值
        int less = left; //左标记
        int great = right; //右标记
        while(less < great) {
            //从前往后找大于基准值的数
            while(less < great && arr[less] <= pivot) {
                less ++;
            }
            //从后往前找小于基准值的数
            while(less < great && arr[great] >= pivot) {
                great --;
            }
            //找到后进行交换
            swap(arr,less,great);
        }
        //循环结束后，基准值还没进行交换，最后要交换
        swap(arr,less,right);
        //此时的less就是接下来继续分区的标志
        return less;
    }

    public int partition2(int[] arr, int left, int right) {
        int pivot = arr[right];
        int less = left;
        int great = right;
        while(less < great) {
            while(less < great && arr[less] <= pivot) {
                less ++;
            }
            arr[great] = arr[less];
            while(less < great && arr[great] >= pivot) {
                great --;
            }
            arr[less] = arr[great];
        }
        arr[less] = pivot;
        return less;
    }
    public int partition3(int[] arr,int left, int right){
        int pivot = arr[right];
        int less = left;
        for (int i = left; i < right; i ++) {
            if(arr[i] < pivot) {
                swap(arr,less,i);
                less ++;
            }
        }
        swap(arr, less, right);
        return less;
    }

    public  void quickSortNoR(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(array.length - 1);
        stack.push(0);

        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();
            if (left >= right) {
                continue;
            }

            int pivotIndex = partition1(array, left, right);
            // [left, pivotIndex - 1]
            // [pivotIndex + 1, right]
            stack.push(right);
            stack.push(pivotIndex + 1);

            stack.push(pivotIndex - 1);
            stack.push(left);
        }
    }

    //归并排序
    private static void merge(int[] array, int low, int mid, int high) {
        int length = high - low;
        int[] extra = new int[length];
        // [low, mid)
        // [mid, high)

        int iLeft = low;
        int iRight = mid;
        int iExtra = 0;

        while (iLeft < mid && iRight < high) {
            if (array[iLeft] <= array[iRight]) {
                extra[iExtra++] = array[iLeft++];
            } else {
                extra[iExtra++] = array[iRight++];
            }
        }

        while (iLeft < mid) {
            extra[iExtra++] = array[iLeft++];
        }

        while (iRight < high) {
            extra[iExtra++] = array[iRight++];
        }

        for (int i = 0; i < length; i++) {
            array[low + i] = extra[i];
        }
    }

    public static void mergeSortNoR(int[] array) {
        for (int i = 1; i < array.length; i = i * 2) {
            for (int j = 0; j < array.length; j = j + 2 * i) {
                int low = j;
                int mid = j + i;
                int high = mid + i;
                if (mid >= array.length) {
                    continue;
                }
                if (high > array.length) {
                    high = array.length;
                }

                merge(array, low, mid, high);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {6,4,9,5,3,7,8};
        new Sort().quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}
