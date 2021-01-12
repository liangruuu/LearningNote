package synchronizedDemo;

/**
 * @PackageName synchronizedDemo
 * @ProjectName java_concurrency_core
 * @Description TODO
 * @Author liangruuu
 * @Date 2020/2/14 11:34
 **/
public class SynchronizedRecursion10 implements Runnable {
  int a = 0;

  @Override
  public void run() {
  }

  private synchronized void method1() {
    System.out.println("这是method1，a=" + a);
    if (a == 0) {
      a++;
      method1();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    SynchronizedRecursion10 synchronizedRecursion10 = new SynchronizedRecursion10();
    synchronizedRecursion10.method1();
  }
}
