package synchronizedDemo;

/**
 * @PackageName synchronizedDemo
 * @ProjectName java_concurrency_core
 * @Description TODO
 * @Author liangruuu
 * @Date 2020/2/14 11:34
 **/
public class SynchronizedSuperClass12 {
  public synchronized void doSomething() {
    System.out.println("我是父类方法");
  }
}

class TestClass extends SynchronizedSuperClass12 {
  @Override
  public synchronized void doSomething() {
    System.out.println("我是子类方法");
    super.doSomething();
  }

  public static void main(String[] args) throws InterruptedException {
    TestClass s = new TestClass();
    s.doSomething();
  }
}