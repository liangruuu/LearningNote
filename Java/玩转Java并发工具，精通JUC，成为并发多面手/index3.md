#### 6. atomic包

#### 6.1 原子类

1. 什么是原子类，有什么作用？
2. 6类原子类纵览
3. Atomic*基本类型原子类，以AtomicInteger为例
4. Atomic*数组类型原子类
5. Atomic*Reference引用类型原子类
6. 把普通变量升级为原子类：用AtomicIntegerFieldUpdater升级原有变量
7. Adder累加器

![1611218406721](assets/1611218406721.png)

****

![1611218419406](assets/1611218419406.png)

#### 6.2 6类原子类纵览

![6类原子类纵览](assets/6类原子类纵览.png)

#### 6.3 AtomicInteger案例演示 

AtomicInteger是对Integer类型的封装，封装好之后就提供了原子的访问和更新操作，背后是基于CAS技术

![1611218609737](assets/1611218609737.png)

![1611218630148](assets/1611218630148.png)

参考代码 src/atomic/AtomicIntegerDemo1.java

![1611218851146](assets/1611218851146.png)

#### 6.4 Atomic数组，每个都安全 

参考代码 src/atomic/AtomicArrayDemo.java

#### 6.5 Atomic引用在自旋锁的应用 

参考代码 src/lock/spinlock/SpinLock.java

#### 6.6 把普通变量升级为原子变量 

![1611219375386](assets/1611219375386.png)

参考代码 src/atomic/AtomicIntegerFieldUpdaterDemo.java

![1611219526289](assets/1611219526289.png)

#### 6.7 Adder累加器

![1611219621354](assets/1611219621354.png)

****

![1611219647652](assets/1611219647652.png)

参考代码 src/atomic/LongAdderDemo.java

