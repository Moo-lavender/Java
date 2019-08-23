import java.util.LinkedList;
import java.util.Queue;
//用队列来生成一个栈
public class MyStackWithQueue {
    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.add(x);
    }

    public int pop(){
        int size  = queue.size();
        for(int i = 1; i < size;i++){
         int element = queue.remove();
         queue.add(element);
     }
        return queue.poll();
    }

    public int top() {
        int size  = queue.size();
        for(int i = 1; i < size;i++){
            int element = queue.remove();
            queue.add(element);
        }
        int v = queue.poll();
        queue.add(v);
        return v;
    }
    public boolean empty() {
        return queue.isEmpty();
    }
}
