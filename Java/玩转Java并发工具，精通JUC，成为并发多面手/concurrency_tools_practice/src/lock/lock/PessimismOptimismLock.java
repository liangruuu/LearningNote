package lock.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述：     TODO
 */
public class PessimismOptimismLock {

    // 乐观锁

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
    }

    // 悲观锁
    int a;
    public synchronized void testMethod() {
        a++;
    }


}
