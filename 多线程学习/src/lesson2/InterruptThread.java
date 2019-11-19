package lesson2;

public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().isInterrupted());
                }
                try {
                //调用sleep()/wait()/join()方法时，线程进入阻塞状态，
                    // 此时也可以进行中断，中断后抛出异常,抛出后重置标志位为false
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
       // Thread.sleep(1000);
        //使用interrupt方法的优势时可以中断阻塞线程
        thread.interrupt();




     /*   Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    //当没中断时，Thread.interrupted()打印一个ture和九个false
                    //标志位为false，调用后返回当前标志位后，再重新将标志位置为false
                   boolean b = Thread.interrupted();//默认没中断时打印了10次false
                   // boolean b = Thread.currentThread().isInterrupted();//默认没中断时打印了10次false
                    //表示创建后初始标志位是false，表示没有被中断
                    System.out.println(b);
                }
            }
        });
        thread2.start();
        thread2.interrupt();//修改标志位时ture!!!*/

    }
}
