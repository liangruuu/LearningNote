package org.simpleframework.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/8
 */
@Slf4j
public class ClassUtil<T> {

    public static final String FILE_PROTOCOL = "file";

    /**
     * 获取包下类的集合
     *
     * @param packageName 包名
     * @return 类集合
     */
    public static Set<Class<?>> extractPackageClass(String packageName) {
        // 1.获取到类的加载器
        ClassLoader classLoader = getClassLoader();
        // 2.通过类加载器获取到加载的资源
        // The name of a resource is a '/'-separated path name that identifies the resource.
        // club.singlelucky.entity替换成club/singlelucky/entity
        // *** 小技巧: 在调试过程中可以通过选中方法packageName.replace(".", "/")，右键点击Evaluate Expression来直接计算出结果
        // url ==> file:/D:/study/code/springframework/target/classes/club/singlelucky/entity
        URL url = classLoader.getResource(packageName.replace(".", "/"));
        if (null == url) {
            log.warn("unable to receive anything from package: " + packageName);
            return null;
        }
        // 3.依据不同的资源类型，采用不同的方式获取资源的集合
        Set<Class<?>> classSet = null;
        // 过滤出file类型的资源
        // url.getProtocol() ==> "file"
        if (FILE_PROTOCOL.equalsIgnoreCase(url.getProtocol())) {
            classSet = new HashSet<>();
            // package的实际路径url.getPath() ==> D:\study\code\springframework\target\classes\club\singlelucky\entity
            File packageDirectory = new File(url.getPath());
            // 从package的实际路径中提取所需的Class文件，因为packageDirectory是一个目录
            // 所以获取到目录之后可以遍历目录及其子目录下的所有文件，并且通过文件拓展名.class提取出类名
            extractClassFile(classSet, packageDirectory, packageName);
        }
        // TODO 此处可以加入针对其他类型资源的处理，比如jar包资源...

        return classSet;
    }

    /**
     * 递归获取目标package里面的所有class文件（包括package里的class文件）
     * 比如fileSource为D:\study\code\springframework\target\classes\club\singlelucky\entity
     * packageName为club.singlelucky.entity
     * 而club.singlelucky.entity包下又存在dto、bo等package
     *
     * @param emptyClassSet 装载目标类的集合
     * @param fileSource    文件或者目录
     * @param packageName   包名
     */
    private static void extractClassFile(Set<Class<?>> emptyClassSet, File fileSource, String packageName) {
        // 递归函数的关键点有两步，第一步是能够推进，第二步是能够终止
        // 1.终止（何时停止递归）：当找到的fileSource是文件而非文件夹就停止递归
        if (!fileSource.isDirectory()) {
            return;
        }
        // 2.如果是一个文件夹，则调用器listFiles方法获取文件夹下的文件或者文件夹
        File[] files = fileSource.listFiles(new FileFilter() {
            // 通过过滤器过滤文件夹以及Class文件，其余格式的文件均抛弃掉
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                } else {
                    // 获取文件的绝对值路径
                    // D:\study\code\springframework\target\classes\club\singlelucky\entity\bo\HeadLine.class
                    String absoluteFilePath = file.getAbsolutePath();
                    if (absoluteFilePath.endsWith(".class")) {
                        // 若是class文件，则直接加载
                        addToClassSet(absoluteFilePath);
                    }
                }
                return false;
            }

            // 根据class文件的绝对值路径，获取并且生成class对象，并放入classSet中
            private void addToClassSet(String absoluteFilePath) {
                /**
                 * 1.从class文件的绝对路径里提取出包含package的类名
                 * 如D:\study\code\springframework\target\classes\club\singlelucky\entity\bo\HeadLine.class
                 * 需要弄成club.singlelucky.entity.bo.HeadLine
                 */
                // D:.study.code.springframework.target.classes.club.singlelucky.entity.bo.HeadLine.class
                absoluteFilePath = absoluteFilePath.replace(File.separator, ".");
                // packageName ==> club.singlelucky.entity
                // club.singlelucky.entity.bo.HeadLine.class
                String className = absoluteFilePath.substring(absoluteFilePath.indexOf(packageName));
                // 除去.class拓展名
                // club.singlelucky.entity.bo.HeadLine
                className = className.substring(0, className.lastIndexOf("."));
                // 2.通过反射机制获取对应的Class对象并且加入到classSet中
                Class<?> targetClass = loadClass(className);
                emptyClassSet.add(targetClass);
            }
        });
        if (null != files) {
            for (File file : files) {
                // 递归调用
                extractClassFile(emptyClassSet, file, packageName);
            }
        }

    }

    /**
     * 获取ClassLoader是一个通用的需求
     * 所以创建一个专门获取ClassLoader实例的通用函数
     * 1. ClassLoader提供了一个`public URL getResource(String name)`
     * Finds the resource with the given name.
     * A resource is some data (images, audio, text, etc) that can be accessed by class code
     * in a way that is independent of the location of the code.
     * 2. 统一资源定位符URL：某个资源的唯一地址，比如常见的http、ftp、file
     * 通过获取java.net.URL实例获取协议名、资源名路径等信息
     *
     * @return 当前的ClassLoader
     */
    public static ClassLoader getClassLoader() {
        /**
         * 程序是通过线程来执行的，而获取到当前执行该方法的线程便能通过线程所属的加载器获取到程序资源信息
         * 因为在实际使用过程中，资源框架和业务项目都被类加载器加载到JVM内存中，所以我们便能定位到业务的package所在路径
         */
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 获取Class对象
     * 如club.singlelucky.entity.bo.HeadLine
     *
     * @param className class全名=package+类名
     * @return Class
     */
    public static Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            log.error("load class error...", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 实例化Class对象
     *
     * @param clazz      class
     * @param accessible 是否支持创建出私有class对象的实例. true为public; false为private
     * @param <T>        class的类型
     * @return 类的实例化
     */
    public static <T> T newInstance(Class<?> clazz, boolean accessible) {
        try {
            // 通过无参构造函数创建对象
            Constructor constructor = clazz.getDeclaredConstructor();
            // 让用户决定是否生成private的实例
            constructor.setAccessible(accessible);
            return (T) constructor.newInstance();
        } catch (Exception e) {
            log.error("newInstance error...", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 设置类的属性值
     *
     * @param field      成员变量
     * @param target     类实例
     * @param value      成员变量的值
     * @param accessible 是否允许设置私有属性
     */
    public static void setField(Field field, Object target, Object value, boolean accessible) {
        field.setAccessible(accessible);
        try {
            field.set(target, value);
        } catch (IllegalAccessException e) {
            log.error("setField error...", e);
            throw new RuntimeException(e);
        }
    }

}
