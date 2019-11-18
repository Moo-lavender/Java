package lesson3;

import jdk.internal.dynalink.linker.LinkerServices;

import java.util.ArrayList;
import java.util.List;

public class UnsafeThread {
    public static int COUNT;    //静态变量大写，基本数据类型在初始化出来后都有默认值
    public static void main(String[] args) {
    //开启20个线程，每个线程对COUNT进行++操作10000次，语气结果200000
        for(int i = 0; i < 20; i++){
             new Thread(new Runnable() {
               @Override
               public void run() {
                   for(int j = 0; j < 10000; j++){
                       COUNT ++;
                   }
               }
           }).start();
        }
        while(Thread.activeCou
        nt() > 2){
            Thread.yield();
        }
        System.out.println(COUNT);

  /*
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            final int k = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0; j < 10000; j++){
                        list.add(k * 10000 + j);
                    }
                }
            }).start();
        }
        while(Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println(list.size());
*/
    }
}
