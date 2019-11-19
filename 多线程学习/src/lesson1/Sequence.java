package lesson1;

public class Sequence {
    public static void main(String[] args) {
        //线程是由操作系统进行调度管理，所以无序
        //启动0-9编号的十个线程，每个线程打印它的编号
       for(int i = 0; i < 10; i ++){
           final int j = i;
           Runnable r = new Runnable() {
               //匿名内部类
               @Override
               public void run() {
                   System.out.println(j);
               }
           };
            Thread t = new Thread(r);
            t.start();
       }
    }
}

