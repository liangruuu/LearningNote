package synchronizedDemo;

public class SynchronizedObjectCodeBlock2 implements Runnable {
  static SynchronizedObjectCodeBlock2 instance1 = new SynchronizedObjectCodeBlock2();
  static SynchronizedObjectCodeBlock2 instance2 = new SynchronizedObjectCodeBlock2();

  @Override
  public void run() {
    synchronized (this) {
      System.out.println("我是对象锁形式, 我叫" + Thread.currentThread().getName());
      try {
        // 有了这2s中阻塞时间，则代码块的运行顺序会更加明显
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        System.out.println(Thread.currentThread().getName() + "运行结束");
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(instance1);
    Thread t2 = new Thread(instance2);
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    while (t1.isAlive() || t2.isAlive()) {
      // 死循环
    }
    System.out.println("finished");
  }
}
