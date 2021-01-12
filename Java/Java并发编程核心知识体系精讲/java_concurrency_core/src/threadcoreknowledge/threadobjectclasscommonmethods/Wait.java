package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * 描述：     展示wait和notify的基本用法 1. 研究代码执行顺序 2. 证明wait释放锁
 */
public class Wait {

  public static Object object = new Object();

  static class Thread1 extends Thread {

    @Override
    public void run() {
      synchronized (object) {
        System.out.println(Thread.currentThread().getName() + "开始执行了");
        try {
          // 抛弃锁
          object.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        // 一旦执行到这行代码就意味着线程又重新拿到了这把锁
        System.out.println("线程" + Thread.currentThread().getName() + "获取到了锁。");
      }
    }
  }

  static class Thread2 extends Thread {

    @Override
    public void run() {
      synchronized (object) {
        object.notify();
        System.out.println("线程" + Thread.currentThread().getName() + "调用了notify()");
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Thread1 thread1 = new Thread1();
    Thread2 thread2 = new Thread2();
    // 保证thread1的wait方法先执行
    thread1.start();
    Thread.sleep(200);
    thread2.start();
  }
}
