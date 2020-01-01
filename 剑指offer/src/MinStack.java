import java.util.Stack;
//实现一个栈的数据结构使得访问min函数表示栈中最小元素时间复杂度为O(1)
public class MinStack {
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
        stack1.push(node);
        int tmp = 0;
        if(!stack2.isEmpty()){
            tmp = stack2.peek();
            if(tmp >= node){
                stack2.push(node);
            }else{
                stack2.push(tmp);
            }
        }else{
            stack2.push(node);
        }
    }
    
    public void pop() {
        stack1.pop();
        stack2.pop();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int min() {
        return stack2.peek();
    }
}