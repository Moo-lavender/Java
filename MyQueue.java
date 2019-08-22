//链表实现队列
public class MyQueue {
    static  class Node{
        int val;
        Node next = null;
        Node(int val){
            this.val = val;
        }
    }

    private  Node front = null;
    private  Node rear = null;
    private  int size = 0;

    public void push(int element){
        size++;
        if(rear != null){
        rear.next = new Node(element);
        rear = rear.next;
        }else {
            front = rear = new Node(element);
        }
    }

    public int pop(){
        int element = front.val;
        front = front.next;
        if(front == null){
            rear = null;
        }
        return  element;
    }

    public int front(){
        return front.val;
    }

    public  int val(){
        return  rear.val;
    }

    public int size(){
        return size;
    }

    public  boolean isEmpty(){
        return size == 0;
    }

}
