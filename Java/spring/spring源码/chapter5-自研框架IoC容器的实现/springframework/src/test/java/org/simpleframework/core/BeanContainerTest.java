package org.simpleframework.core;

import club.singlelucky.controller.DispatcherServlet;
import club.singlelucky.controller.frontend.MainPageController;
import club.singlelucky.service.solo.HeadLineService;
import club.singlelucky.service.solo.impl.HeadLineServiceImpl;
import org.junit.jupiter.api.*;
import org.simpleframework.core.annotation.Controller;

import java.lang.reflect.Member;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/8
 */
// @TestMethodOrder(MethodOrderer.OrderAnnotation.class) & @Order(1)
// 因为beanContainer.loadBeans需要在最开始被执行，所以测试类也需要有先后顺序
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BeanContainerTest {
    private static BeanContainer beanContainer;

    @BeforeAll
    static void init() {
        beanContainer = BeanContainer.getInstance();
    }

    @DisplayName("加载目标类机及其实例到BeanContainer：loadBeansTest")
    @Order(1)
    @Test
    public void loadBeansTest() {
        // 在未初始化容器之前的loaded值为false
        Assertions.assertEquals(false, beanContainer.isLoaded());
        // 把club.singlelucky包下被Controller、Service修饰的类都加载到容器里
        beanContainer.loadBeans("club.singlelucky");
        // 一共5个被Controller、Service修饰的类
        Assertions.assertEquals(5, beanContainer.size());
        // 初始化容器之后的loaded值为true
        Assertions.assertEquals(true, beanContainer.isLoaded());
    }

    @DisplayName("根据类获取其实例：getBeanTest")
    @Order(2)
    @Test
    public void getBeanTest() {
        MainPageController controller = (MainPageController) beanContainer.getBean(MainPageController.class);
        //由于MainPageController类被添加了Controller注解，所以能被容器扫描到
        Assertions.assertEquals(true, controller instanceof MainPageController);
        // 而DispatcherServlet类没有被Controller注解，所以容器扫描不到也无法通过容器获取实例对象
        DispatcherServlet servlet = (DispatcherServlet) beanContainer.getBean(DispatcherServlet.class);
        Assertions.assertEquals(null, servlet);
    }

    @DisplayName("根据注解获取对应的实例：getClassesByAnnotationTest")
    @Order(3)
    @Test
    public void getClassesByAnnotationTest() {
        Assertions.assertEquals(true, beanContainer.isLoaded());
        // 被Controller注解标记的类一共有2个
        Assertions.assertEquals(2, beanContainer.getClassesByAnnotation(Controller.class).size());
    }

    @DisplayName("根据接口获取实现类：getClassesBySuperTest")
    @Order(4)
    @Test
    public void getClassesBySuperTest() {
        Assertions.assertEquals(true, beanContainer.isLoaded());
        Assertions.assertEquals(true, beanContainer.getClassesBySuper(HeadLineService.class).contains(HeadLineServiceImpl.class));
    }
}
