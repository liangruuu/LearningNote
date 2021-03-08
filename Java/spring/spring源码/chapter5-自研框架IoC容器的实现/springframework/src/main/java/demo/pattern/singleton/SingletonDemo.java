package demo.pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/8
 */
public class SingletonDemo {
    public static void main(String[] args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /**
         * 调用两次返回的是同一个对象
         * demo.pattern.singleton.StarvingSingleton@2503dbd3
         * demo.pattern.singleton.StarvingSingleton@2503dbd3
         */
        System.out.println(StarvingSingleton.getInstance());
        System.out.println(StarvingSingleton.getInstance());
        /**
         * 调用两次返回的是同一个对象
         * demo.pattern.singleton.LazyDoubleCheckSingleton@4b67cf4d
         * demo.pattern.singleton.LazyDoubleCheckSingleton@4b67cf4d
         */
        System.out.println(LazyDoubleCheckSingleton.getInstance());
        System.out.println(LazyDoubleCheckSingleton.getInstance());

        /**
         * 我们使用单例模式设计类的目的就是为了让外界通过静态方法getInstance来获取实例
         * 但即使是私有构造函数也能通过反射机制来获取对象，即绕过了静态方法getInstance
         * demo.pattern.singleton.StarvingSingleton@7ea987ac
         */
        Class clazz = StarvingSingleton.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        System.out.println(constructor.newInstance());

        /**
         * 通过对象示例获取到的instance和直接通过类的静态方法获取到的instance是同一个
         * demo.pattern.singleton.EnumStarvingSingleton@12a3a380
         * demo.pattern.singleton.EnumStarvingSingleton@12a3a380
         * 这就说明了反射虽然攻克了EnumStarvingSingleton的外围防线
         * 但暂时没法攻克ContainerHolder里的instance实例
         */
        System.out.println(EnumStarvingSingleton.getInstance());
        Class clazz2 = EnumStarvingSingleton.class;
        Constructor constructor2 = clazz2.getDeclaredConstructor();
        constructor2.setAccessible(true);
        EnumStarvingSingleton enumStarvingSingleton = (EnumStarvingSingleton) constructor2.newInstance();
        System.out.println(enumStarvingSingleton.getInstance());

    }
}
