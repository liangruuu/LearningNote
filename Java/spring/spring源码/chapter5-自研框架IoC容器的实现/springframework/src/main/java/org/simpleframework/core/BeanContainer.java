package org.simpleframework.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.simpleframework.core.annotation.Component;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.core.annotation.Repository;
import org.simpleframework.core.annotation.Service;
import org.simpleframework.util.ClassUtil;
import org.simpleframework.util.ValidationUtil;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/8
 */
@Slf4j
// 由lombok提供的私有构造函数创建，访问修饰符为private
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanContainer {

    /**
     * 存放所有被配置标记的目标对象的Map
     * final: 一开始就被初始化好了
     * Map<Class<?>, Object>: 用来存放Class对象以及它对应的由newInstance创建出来的实例
     */
    private final Map<Class<?>, Object> beanMap = new ConcurrentHashMap<>();

    /**
     * 配置的获取与管理：加载bean的注解列表
     * 当类被Component、Controller、Service、Repository注解的话，这些类及其实例就需要通过BeanContainer管理起来
     */
    private static final List<Class<? extends Annotation>> BEAN_ANNOTATION
            = Arrays.asList(Component.class, Controller.class, Service.class, Repository.class);

    /**
     * 获取IOC容器的实例
     *
     * @return BeanContainer
     */
    public static BeanContainer getInstance() {
        return ContainerHolder.HOLDER.instance;
    }

    private enum ContainerHolder {
        HOLDER;
        private BeanContainer instance;

        ContainerHolder() {
            instance = new BeanContainer();
        }
    }

    /**
     * 由于容器载体的加载是一个比较耗时的过程，为了防止重复加载，
     * 可以给容器新增一个私有的bool类型的名为loaded的成员变量，防止容器多次加载
     * 容器是否已经加载过Bean
     */
    private boolean loaded = false;

    /**
     * @return 是否已经加载过Bean
     */
    public boolean isLoaded() {
        return loaded;
    }

    /**
     * Bean实例数量
     *
     * @return 数量
     */
    public int size() {
        return beanMap.size();
    }

    /**
     * 扫描加载所有的Bean
     * synchronized用于添加互斥逻辑
     * 因为如果有多个线程同时执行loadBeans方法，loaded又是共享变量，则可能会出现多个线程执行方法时的loaded值都为true
     * 这就导致了多次加载Bean容器
     *
     * @param packageName 包名
     */
    public synchronized void loadBeans(String packageName) {
        // 判断bean容器是否被加载过
        if (isLoaded()) {
            log.warn("BeanContainer has been loaded...");
            return;
        }

        Set<Class<?>> classSet = ClassUtil.extractPackageClass(packageName);
        // 把classSet == null || classSet.isEmpty()逻辑抽出成一个单独的校验类ValidationUtil
        if (ValidationUtil.isEmpty(classSet)) {
            log.warn("extract nothing from packageName" + packageName);
            return;
        }
        for (Class<?> clazz : classSet) {
            for (Class<? extends Annotation> annotation : BEAN_ANNOTATION) {
                // 如果类上标记了定义的注解
                if (clazz.isAnnotationPresent(annotation)) {
                    /**
                     * 将目标类本身作为键，目标类的实例作为值，放入到beanMap中
                     * beanMap.put(clazz, clazz.newInstance());
                     * 因为clazz.newInstance()是一个过时方法，并且获取Class对应的实例是一个通用的方法
                     * 所以可以在ClassUtil类中定义创建Class对象的方法
                     * ClassUtil.newInstance(clazz, true)表示生成一个public对象
                     */
                    beanMap.put(clazz, ClassUtil.newInstance(clazz, true));
                }
            }
        }

        loaded = true;
    }

    /**
     * 添加一个class对象及其Bean实例
     *
     * @param clazz Class对象
     * @param bean  Bean实例
     * @return 原有的Bean实例，没有则返回null
     */
    public Object addBean(Class<?> clazz, Object bean) {
        return beanMap.put(clazz, bean);
    }

    /**
     * 移除一个IOC容器管理的对象
     *
     * @param clazz Class对象
     * @return 删除的Bean实例，没有则返回null
     */
    public Object removeBean(Class<?> clazz) {
        return beanMap.remove(clazz);
    }

    /**
     * 根据Class对象获取Bean实例
     *
     * @param clazz Class对象
     * @return Bean实例
     */
    public Object getBean(Class<?> clazz) {
        return beanMap.get(clazz);
    }

    /**
     * 获取容器管理的所有Class对象集合
     *
     * @return Class集合
     */
    public Set<Class<?>> getClasses() {
        return beanMap.keySet();
    }

    /**
     * 获取所有Bean对象
     *
     * @return Bean集合
     */
    public Set<Object> getBeans() {
        return new HashSet<>(beanMap.values());
    }

    /**
     * 根据注解筛选出Bean的Class集合
     *
     * @param annotation 注解
     * @return Class集合
     */
    public Set<Class<?>> getClassesByAnnotation(Class<? extends Annotation> annotation) {
        // 1.获取beanMap的所有class对象
        Set<Class<?>> keySet = getClasses();
        if (ValidationUtil.isEmpty(keySet)) {
            log.warn("nothing in beanMap...");
            return null;
        }
        // 2.通过注解筛选被注解标记的class对象，并添加到classSet里
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> clazz : keySet) {
            // 类是否有相关的注解标记
            if (clazz.isAnnotationPresent(annotation)) {
                classSet.add(clazz);
            }
        }
        return classSet.size() > 0 ? classSet : null;
    }

    /**
     * 通过接口或者父类获取实现类的或者子类的Class集合，不包括其本身
     *
     * @param interfaceOrClass 接口Class或者父类Class
     * @return Class集合
     */
    public Set<Class<?>> getClassesBySuper(Class<?> interfaceOrClass) {
        // 1.获取beanMap的所有class对象
        Set<Class<?>> keySet = getClasses();
        if (ValidationUtil.isEmpty(keySet)) {
            log.warn("nothing in beanMap...");
            return null;
        }
        // 2.判断keySet里的元素是否是传入的接口或者类的子类，如果是就添加到classSet里
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> clazz : keySet) {
            // 判断keySet里的元素是否是传入的接口或者类的子类
            // parent.isAssignableFrom(child) ==> true
            // child.isAssignableFrom(child) ==> true
            // !clazz.equals(interfaceOrClass) 排除本身的情况
            if (interfaceOrClass.isAssignableFrom(clazz) && !clazz.equals(interfaceOrClass)) {
                classSet.add(clazz);
            }
        }
        return classSet.size() > 0 ? classSet : null;
    }
}
