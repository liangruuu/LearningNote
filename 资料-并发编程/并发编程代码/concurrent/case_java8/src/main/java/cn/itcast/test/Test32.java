package cn.itcast.test;

import lombok.extern.slf4j.Slf4j;

import static cn.itcast.n2.util.Sleeper.sleep;

@Slf4j(topic = "c.Test32")
public class Test32 {
    // 易变
    static boolean run = true;

    // 锁对象
    final static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            while(true){
                    synchronized (lock){
                      if(!run){
                        break;
                      }
                    }
            }
        });
        t.start();

        sleep(1);
        synchronized (lock){
          run = false; // 线程t不会如预想的停下来
        }
    }
}
