package lesson5;

public class Notify {
    private static volatile int COUNT ;
    public static void main(String[] args) {
        //prodece
       for(int i = 0; i < 3; i++){
           new Thread(new Runnable() {
               @Override
               public void run() {
                   try {
                       for (int j = 0; j < 10; j++) {
                          synchronized (Notify.class){
                             while (COUNT+3 > 100){//为了再被唤醒后因为存量更改而再次判断是否满足生产条件
                                 //当前线程释放锁，阻塞并等待其它线程唤醒调用notify或者notifyAll唤醒
                                  Notify.class.wait();
                              }
                              produce();
                              System.out.println(Thread.currentThread().getName() + "生产，库存总量为"+COUNT);
                              Thread.sleep(500);
                              Notify.class.notifyAll();
                          }
                          Thread.sleep(500);
                       }
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }).start();
       }
       //consume
        for(int i = 0; i < 10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while(true){
                            synchronized(Notify.class){
                                while (COUNT == 0){
                                    Notify.class.wait();
                                }
                                consume();
                                System.out.println(Thread.currentThread().getName() + "消费，库存总量为"+COUNT);
                                Thread.sleep(500);
                                Notify.class.notifyAll();
                            }
                            Thread.sleep(500);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public synchronized static void produce(){
        COUNT += 3;
    }
    public synchronized static void consume(){
        COUNT --;
    }

}
