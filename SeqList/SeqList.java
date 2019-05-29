import java.util.Arrays;
public class SeqList{
	//属性
	private int[] array;  //保存数据
	private int size;     //已经有的数据个数
	
	//构造方法
	public SeqList(){
		//1.初始化array
		//2.初始化size
		array = new int[11];  //动态初始化，必须知道长度
		size = 0;
		
	}
	//支持的方法
	//插 头插O(n) 尾插O(1) 插入O(n)
	public  void pushFront(int element){
		//从后往前遍历，否则数据会被覆盖
		for (int i = size - 1; i >=0; i--){
		array[i+1] = array[i];
		}
		array[0] = element;
		size ++;
	}
	public  void pushBack(int element){
		array[size ++] = element;
		//先不考虑array放不下的情况
	}
	public void insert(int index , int element){
		if (index < 0|| index >size){
			System.out.printf("插入位置不合法");
			return;
		}
		for(int i = size-1;i >= index;i--){
			array[i+1] = array[i];
		}
		array[index] = element;
		size ++;
		/*for(int i = size; i > index;i--){
			array[i] = array[i-1];
		}*/
		/*for (int i = 0; i < size - index ;i++){
			array[size - i] = array[size - i - 1];
		}*/
	}
	//删
	public void popFront(){
		for(int i = 0;i < size - 1; i++){
			array[i] = array[i+1];
		}
		size --;
	}
	public void popBack(){
		array[--size] =0;
	}
	public void erase(int index){
		for(int i = 0; i <= size - index; i++){
			array[index] = array[index + 1];
		}
		size--;
	}
	//查
	public int indexOf(int element){
		for(int i = 0; i < size; i++){
			if(array[i] == element){
				System.out.printf("找到了！下标是%d%n",i);
				return i;
			}
		}
		System.out.printf("找不到");
		return -1;		
		
	}
	//改
	public void size(){
		System.out.printf("%d%n",size);
	} 
	
	
	public void set(int index,int element){
		array[index] = element;
	}
	public void remove(int element){
		int index = indexOf(element); //时间O(n^2)  空间O(1)
		if(index != -1){
			erase(index);
		}
	}
	public void removeAll(int element){
		
		/*int index;
		while((index = indexOf(element))!= -1){   //O(n^2)
			erase(index);                   
		}
		int[] newArray = new int[size];  //时间O(n)  空间O(n) 
		int j = 0;
		for(int i = 0; i <size; i++){
			if (array[i] != element){
				newArray[j++] = array[i];
			}
		}
		for(int i = 0;i < j; i++){
			array[i] = newArray[i];
		}
		size = j;*/
		int j = 0;                 //时间O(n)  空间O(1) 
		for(int i = 0; i < size; i++){
			if (array[i] != element){
				array[j++] = array[i];
			}
		}
		size = j;
	}
	public String toString(){
		return Arrays.toString(Arrays.copyOf(array,size));
	}
	public static void main(String[] args){
		SeqList seqList= new SeqList();
		seqList.pushFront(10);
		seqList.pushFront(20);
		seqList.pushFront(30);
		System.out.println(seqList.toString());
		seqList.pushBack(40);
		seqList.pushBack(50);
		System.out.println(seqList.toString());
		seqList.insert(2,25);
		System.out.println(seqList.toString());
		seqList.popFront();
		System.out.println(seqList.toString());
		seqList.popBack();
		System.out.println(seqList.toString());
		seqList.set(3,500);
		System.out.println(seqList.toString());
		seqList.indexOf(25);
		System.out.println(seqList.toString());
		seqList.size();
		seqList.pushBack(25);
		System.out.println(seqList.toString());
		//seqList.remove(10);
		//System.out.println(seqList.toString());
		seqList.removeAll(25);
		System.out.println(seqList.toString());
		
	}
	
}