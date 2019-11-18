package lesson2;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ThreadAdvantage {
    /*
    *集合：
    *Collection   /-----List:
    *                       ArrayList
    *                       LinkedList
    *            /------Set:
    *                       HashSet,TreeSet
    * Map       /-----Map:
    *                       HashMap,TreeMap
    * */
    public static List<String> randomList(){
        List<String> list = new LinkedList<>();
        char[] chars = {'a','b'};
        for(int i = 0; i < 100000; i ++){
            int random = new Random().nextInt(chars.length);
            char c = chars[random];
            list.add(String.valueOf(c));
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = randomList();
        //创建10个线程，每个线程获取list中的10000个元素
        long start = System.currentTimeMillis();
        for(int i = 0; i < 10; i++){
            final int k = i;
            new Thread(new Runnable(){
                @Override
                public void run(){
                    for(int j = 0; j < 10000; j++){
                        list.get(k * 10000 + j);
                    }
                }
            }).start();
        }
        //第一种方法：线程让步()
        while(Thread.activeCount() > 2){
            Thread.yield();
        }

        /*
        第二种方法：阻塞
        先声明每一个线程，然后遍历每一个线程，调用join方法
        Thread[] threads = new Thread[10];
        for(int i = 0; i < 10; i++){
        final int k = i;

        threads[i] = new Thread(new Runnable(){
            @Override
            public void run(){
                for(int j = 0; j < 10000; j++){
                    list.get(k * 10000 + j);
                }
            }
        });
        threads[i].start();
        }
        for(Thread thread : threads){
            thread.join();
        }
        */
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
