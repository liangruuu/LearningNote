package demo.pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/8
 */
public class EnumStarvingSingleton {
    private EnumStarvingSingleton() {
    }

    public static EnumStarvingSingleton getInstance() {
        return ContainerHolder.HOLDER.instance;
    }

    private enum ContainerHolder {
        HOLDER;
        // 单例对象被存放在HOLDER中
        private EnumStarvingSingleton instance;

        ContainerHolder() {
            instance = new EnumStarvingSingleton();
        }
    }

    // Exception in thread "main" java.lang.IllegalArgumentException: Cannot reflectively create enum objects
    //	at java.lang.reflect.Constructor.newInstance(Constructor.java:417)
    // 反射无法调用枚举的私有构造函数，因此这种方式是较为安全的创建容器的方法
    public static void main(String[] args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = ContainerHolder.class;
        Constructor constructor = clazz.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        System.out.println(EnumStarvingSingleton.getInstance());
        System.out.println(constructor.newInstance());
    }
}
