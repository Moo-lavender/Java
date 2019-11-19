package lesson04;

public class SafeThread {
    public static int COUNT;    //静态变量大写，基本数据类型在初始化出来后都有默认值
    public static void main(String[] args) {
        //开启20个线程，每个线程对COUNT进行++操作10000次，语气结果200000
        Object object = new Object();
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        //第一种静态类对象锁定
                        increment();
                        decrement();
                        /*第二种：对于实例对象锁定
                        synchronized (object){
                            COUNT ++;
                        }*/
                    }
                }
            }).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(COUNT);
    }
    public synchronized static void increment(){
        COUNT ++;
    }
    public synchronized  static void decrement(){
        COUNT --;
    }
    public synchronized void increment2(){
    }
    //等同于下面的方法
    /*public  void increment2(){
        synchronized(this)
    }*/


}
//synchronized 实现当前代码块中的同步互斥