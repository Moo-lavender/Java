package lesson04;

public class SynchronizedTest {
    /* 静态演示
    public synchronized static void method1(){
        System.out.println(Thread.currentThread().getName());
        while(true){ }
    }
    public synchronized static void method2(){
        System.out.println(Thread.currentThread().getName());
        while (true){ }
    }
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                method1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                method2();
            }
        }).start();
    }
 */

    /*实例演示
    public static void main(String[] args) {
        MyObject o = new MyObject();
        MyObject o2 = new MyObject();
        new Thread(new Runnable() {
            @Override
            public void run() {
                o.method1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                o2.method2();
            }
        }).start();
    }
     */

    /*代码块演示
    public static void main(String[] args) {
        MyObject o = new MyObject();
        MyObject o2 = new MyObject();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    System.out.println(Thread.currentThread().getName());
                    while(true){ }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    System.out.println(Thread.currentThread().getName());
                    while(true){ }
                }
            }
        }).start();
    }
     */

}
class MyObject{
    public synchronized void method1(){
        System.out.println(Thread.currentThread().getName());
        while(true){ }
    }
    public synchronized void method2(){
        System.out.println(Thread.currentThread().getName());
        while(true){ }
    }
}
