package synchronizedDemo;

/**
 * @PackageName synchronizedDemo
 * @ProjectName java_concurrency_core
 * @Description 同时访问同步方法和非同步方法
 * @Author liangruuu
 * @Date 2020/2/14 11:25
 **/
public class SynchronizedYesAndNo6 implements Runnable {
  static SynchronizedYesAndNo6 instance = new SynchronizedYesAndNo6();

  @Override
  public void run() {
    if ("Thread-0".equals(Thread.currentThread().getName())) {
      method1();
    } else {
      method2();
    }
  }

  public synchronized void method1() {
    System.out.println("我叫加锁方法，我叫" + Thread.currentThread().getName());
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      System.out.println(Thread.currentThread().getName() + "运行结束");
    }
  }

  public void method2() {
    System.out.println("我叫没加锁方法，我叫" + Thread.currentThread().getName());
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      System.out.println(Thread.currentThread().getName() + "运行结束");
    }
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
