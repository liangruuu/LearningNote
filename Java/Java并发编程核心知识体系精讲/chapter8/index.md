![1581673541190](assets/1581673541190.png)

## 1. 线程各属性

![1581673572927](assets/1581673572927.png)

### 1.1 线程ID

```java
/**
 * 描述：     ID从1开始，JVM运行起来后，我们自己创建的线程的ID早已不是2.
 */
public class Id {

  public static void main(String[] args) {
    Thread thread = new Thread();
    System.out.println("主线程的ID" + Thread.currentThread().getId());
    System.out.println("子线程的ID" + thread.getId());
  }
}
```

![1581673676649](assets/1581673676649.png)

### 1.2 线程名字

![1581673720547](assets/1581673720547.png)

![1581673746007](assets/1581673746007.png)

![1581673772636](assets/1581673772636.png)

### 1.3 守护线程(比如垃圾处理者...)

![1581673825606](assets/1581673825606.png)

被JVM自动启动

![1581673924321](assets/1581673924321.png)

