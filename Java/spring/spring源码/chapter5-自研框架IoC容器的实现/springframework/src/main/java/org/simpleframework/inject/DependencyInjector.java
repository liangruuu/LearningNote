package org.simpleframework.inject;

import lombok.extern.slf4j.Slf4j;
import org.simpleframework.core.BeanContainer;
import org.simpleframework.inject.annotation.AutoWired;
import org.simpleframework.util.ClassUtil;
import org.simpleframework.util.ValidationUtil;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/8
 */
@Slf4j
public class DependencyInjector {
    // Bean容器
    private BeanContainer beanContainer;

    public DependencyInjector() {
        beanContainer = BeanContainer.getInstance();
    }

    /**
     * 执行Ioc
     */
    public void doIoc() {
        // 1.遍历Bean容器中所有的Class对象
        if (ValidationUtil.isEmpty(beanContainer.getClasses())) {
            log.warn("empty classes in BeanContainer...");
            return;
        }
        for (Class<?> clazz : beanContainer.getClasses()) {
            // 2.遍历Class对象的所有成员变量
            Field[] fields = clazz.getDeclaredFields();
            if (ValidationUtil.isEmpty(fields)) {
                continue;
            }
            for (Field field : fields) {
                AutoWired autoWired = field.getAnnotation(AutoWired.class);
                String autowiredValue = autoWired.value();

                // 3.找出被AutoWired标记的成员变量
                if (field.isAnnotationPresent(AutoWired.class)) {
                    // 4.获取这些成员变量的类型
                    Class<?> fieldClass = field.getType();
                    // 5.获取这些成员变量的类型在容器里对应的实例
                    Object fieldValue = getFieldInstance(fieldClass, autowiredValue);
                    if (fieldValue == null) {
                        throw new RuntimeException("unable to inject relevant type, target fieldClass is: " + fieldClass.getName() + " autowiredValue is: " + autowiredValue);
                    } else {
                        // 6.通过反射将对应的成员变量实例注入到成员变量所在类的实例里
                        Object targetBean = beanContainer.getBean(clazz);
                        ClassUtil.setField(field, targetBean, fieldValue, true);
                    }
                }
            }
        }
    }

    /**
     * 根据Class在beanContainer里获取其实例或者实现类
     * 比如MainPageController类中有成员变量HeadLineShopCategoryCombineService
     * 但是HeadLineShopCategoryCombineService是一个接口，并不是实现类，同时它并没有被@Service标记
     * 我们需要的是接口对应的实现类HeadLineShopCategoryCombineServiceImpl，该实现类被@Service标记
     *
     * @param fieldClass 成员变量类
     * @return 成员变量
     */
    private Object getFieldInstance(Class<?> fieldClass, String autowiredValue) {
        Object fieldValue = beanContainer.getBean(fieldClass);
        /**
         * 若不为空则表明成员变量的类型并非是接口而是其实现类，所以我们将其返回
         * 若为空则表明成员变量对应的类型是接口，如果返回的是HeadLineShopCategoryCombineService类
         * 而该类又未被标记Service注解，因而不会被容器管理起来
         */
        if (fieldValue != null) {
            return fieldValue;
        } else {
            // 获取fieldClass对应的实现类
            Class<?> implementedClass = getImplementClass(fieldClass, autowiredValue);
            if (implementedClass != null) {
                return beanContainer.getBean(implementedClass);
            } else {
                return null;
            }
        }
    }

    /**
     * 获取接口的实现类
     *
     * @param fieldClass 成员变量类
     * @return 接口的实现类
     */
    private Class<?> getImplementClass(Class<?> fieldClass, String autowiredValue) {
        /**
         * 如果出现了多个实现类该怎么办呢?
         * 如 A a; / A aa;
         * 对于Spring框架而言，它也考虑到了这样一种情况，即对同一个接口有多个实现类的问题
         * Spring在AutoWired的基础上还外加了一个叫Qualifier标签，在Qualifier标签制定具体的实现类名，以便业务方进一步告诉容器需要使用哪个实现类来进行注入操作
         * public class Controller{
         *     @Qualifier("Chinese")   // 指定注入的是Chinese bean
         *     @AutoWired
         *     private Person person;
         * }
         * 在自研框架中尝试使用最简单的实现方式：给AutoWired注解定义value属性，从而获取autowiredValue值
         */
        Set<Class<?>> classSet = beanContainer.getClassesBySuper(fieldClass);
        if (!ValidationUtil.isEmpty(classSet)) {
            if (ValidationUtil.isEmpty(autowiredValue)) {
                if (classSet.size() == 1) {
                    return classSet.iterator().next();
                } else {
                    // 如果多于两个实现类且用户未指定其中一个实现类，则抛出异常
                    throw new RuntimeException("multiple implemented classes for " + fieldClass.getName() + " please set @AutoWired's value to pick one");
                }
            } else {
                for (Class<?> clazz : classSet) {
                    // clazz.getSimpleName(): 去除package之后的名字
                    if (autowiredValue.equals(clazz.getSimpleName())) {
                        return clazz;
                    }
                }
            }
        }
        return null;
    }
}
