public class ProduceAndConsume {
    //设置共享变量COUNT
    private static volatile int COUNT;

    public static void main(String[] args) {
        //生产者
        //创建三个线程，每一个线程就为一个生产者，生产者执行一次使得COUNT + 1
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //每个生产者可以连续工作十次
                        for (int j = 0; j < 10; j++) {
                            synchronized (ProduceAndConsume.class) {
                                //如果生产者生产后，COUNT>10就开始等待
                                //注意：此处不使用if判断是为了防止wait方法返回后不能及时再次判断COUNT
                                while (COUNT + 1 > 10) {
                                    //当前线程释放锁，等待唤醒
                                    ProduceAndConsume.class.wait();
                                }
                                //库存不满就生产
                                produce();
                                System.out.println(Thread.currentThread().getName() + "生产，库存总量为" + COUNT);
                                //每次生产后睡眠一段时间
                                Thread.sleep(500);
                                //生产后有库存，就唤醒所有等待的消费者
                                ProduceAndConsume.class.notifyAll();
                            }
                            //睡眠一段时间，留出时间让其他线程竞争锁
                            Thread.sleep(500);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }

        //消费者
        //创建三个线程，表示有三个消费者
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while(true) {
                            //三个消费者均可一直消费
                            synchronized (ProduceAndConsume.class) {
                                //库存为0，则停止消费
                                while (COUNT == 0) {
                                    ProduceAndConsume.class.wait();
                                }
                                consume();
                                System.out.println(Thread.currentThread().getName() + "消费，库存总量为" + COUNT);
                                Thread.sleep(500);
                                ProduceAndConsume.class.notifyAll();
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
    //生产消费的同步方法
    public static synchronized void produce(){
        COUNT ++;
    }
    public static synchronized void consume(){
        COUNT --;
    }
}