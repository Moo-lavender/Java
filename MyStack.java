import java.util.Arrays;
//顺序表实现栈
public class MyStack {
    private int[] array;
    private  int top;
    public void ensureCapacity(){
        if (top < array.length){
            return;
        }
        array = Arrays.copyOf(array,2*array.length);
    }
    public int push(int element){
        ensureCapacity();
        array[top++] = element;
        return element;
    }
    public void pop(){
        array[--top] = 0;
    }
    public  int peek(){
        return array[top-1];
    }
    public boolean empty(){
        return  top ==0;
    }
    public int size(){
        return top;
    }

}
