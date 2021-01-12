package synchronizedDemo;


public class SynchronizedStatic4 implements Runnable {
  static SynchronizedStatic4 instance1 = new SynchronizedStatic4();
  static SynchronizedStatic4 instance2 = new SynchronizedStatic4();

  public static synchronized void method(){
    System.out.println("我是类锁的第一种形式，我叫" + Thread.currentThread().getName());
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
