package synchronizedDemo;

public class SynchronizedObjectMethod3 implements Runnable {
  static SynchronizedObjectMethod3 instance = new SynchronizedObjectMethod3();

  public synchronized void method() {
    System.out.println("我叫对象锁的方法修饰形式，我叫" + Thread.currentThread().getName());
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      System.out.println(Thread.currentThread().getName() + "运行结束");
    }
  }

  @Override
  public void run() {
    method();
  }

  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(instance);
    Thread t2 = new Thread(instance);
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
