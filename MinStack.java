import java.util.Stack;

public class MinStack {
    Stack<Integer> normal = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public MinStack() {}

    public void push(int x){
        normal.push(x);
        if (min.empty()){
            min.push(x);
        }else{
            int m = min.peek();
            if(m < x){
                min.push(m);
            }else {
                min.push(x);
            }
        }

    }

    public void pop() {
        normal.pop();
        min.pop();
    }

    public int top() {
        return normal.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

