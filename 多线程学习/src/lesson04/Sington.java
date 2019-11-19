package lesson04;

public class Sington {
    //饿汉式
    private static final Sington SINGTON = new Sington();
    private Sington(){}

    //懒汉式(不安全)
    private volatile static Sington SINGTON2 = null;
    public static Sington getSington2(){
        if(SINGTON2 == null){
            //多个线程可以同时进入这行代码进行判断，都判断为null
           SINGTON2 = new Sington();
        }
        return SINGTON2;
    }

    //synchronization的第一种写法
    public synchronized static Sington getSington3(){
        /*等同于
        synchronized (Sington.class){
            if(SINGTON2 == null){
            //多个线程可以同时进入这行代码进行判断，都判断为null
            SINGTON2 = new Sington();
        }
        return SINGTON2;
        }
         */
        if(SINGTON2 == null){
            SINGTON2 = new Sington();
        }
        return SINGTON2;
    }

    //synchronization第二种写法---面试就写这种
    public static Sington getSington4(){
        if(SINGTON2 == null) {
            synchronized (Sington.class) {
                //1.分配对象的内存空间
                //2.执行对象初始化
                //3.把对象赋给引用
                //可能发生重排序
                if(SINGTON2 == null) {
                    SINGTON2 = new Sington();
                }
            }
        }
        return SINGTON2;
    }





    public static Sington getInstance(){
        return SINGTON;
    }
    public static Sington getInstance2(){
        return SINGTON2;
    }

}
