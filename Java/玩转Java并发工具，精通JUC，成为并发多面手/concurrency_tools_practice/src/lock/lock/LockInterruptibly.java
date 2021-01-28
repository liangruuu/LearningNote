package lock.lock;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述：     TODO
 */
public class LockInterruptibly implements Runnable {

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockInterruptibly lockInterruptibly = new LockInterruptibly();
        Thread thread0 = new Thread(lockInterruptibly);
        Thread thread1 = new Thread(lockInterruptibly);
        thread0.start();
        thread1.start();

        try {
            /**
             * 这里的睡眠操作是为了让thread1.interrupt()能在线程睡眠的时候执行
             * 不然没有阻塞2s的话，interrupt()会在线程线程睡眠之前就被执行，那么打断就没有意义了
             */
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        thread0.interrupt();
        thread1.interrupt();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "尝试获取锁");
        try {
            lock.lockInterruptibly();
            try {
                System.out.println(Thread.currentThread().getName() + "获取到了锁");
                /**
                 * 本身若不进行睡眠的话，线程一随即会执行finally语句块里的unlock方法释放锁
                 * 睡眠的目的就是为了不让线程一轻易地释放锁，另一个线程轻易地获取锁
                 * 这样等待第二个线程来之后因为没有获取锁对象，就会阻塞在lock.lockInterruptibly()处。
                 * 此时Interrupt正处于就绪状态的第二个线程，则会被捕获异常
                 * 如果Interrupt的对象是处于睡眠状态的线程一的话也是会被捕获异常的
                 * 所以正如代码所示，外层的try-catch是捕获线程一产生的异常
                 * 而里层的try-catch是捕获线程二产生的异常
                 */
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "睡眠期间被中断了");
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放了锁");
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "获得锁期间被中断了");
        }
    }
}
