package synchronizedDemo;

/**
 * @PackageName synchronizedDemo
 * @ProjectName java_concurrency_core
 * @Description TODO
 * @Author liangruuu
 * @Date 2020/2/14 11:34
 **/
public class SynchronizedOtherMethod11 implements Runnable {
  @Override
  public void run() {
  }

  private synchronized void method1() {
    System.out.println("我是method1");
    method2();
  }

  private synchronized void method2() {
    System.out.println("我是method2");
  }

  public static void main(String[] args) throws InterruptedException {
    SynchronizedOtherMethod11 synchronizedRecursion10 = new SynchronizedOtherMethod11();
    synchronizedRecursion10.method1();
  }
}
