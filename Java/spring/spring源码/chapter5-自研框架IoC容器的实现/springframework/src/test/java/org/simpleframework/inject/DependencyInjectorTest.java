package org.simpleframework.inject;

import club.singlelucky.controller.frontend.MainPageController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.simpleframework.core.BeanContainer;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/8
 */
public class DependencyInjectorTest {
    @DisplayName("依赖注入doIoc")
    @Test
    public void doIocTest() {
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("club.singlelucky");
        Assertions.assertEquals(true, beanContainer.isLoaded());
        MainPageController mainPageController = (MainPageController) beanContainer.getBean(MainPageController.class);
        Assertions.assertEquals(true, mainPageController instanceof MainPageController);
        // 依赖注入之前HeadLineShopCategoryCombineService的值为null
        Assertions.assertEquals(null, mainPageController.getHeadLineShopCategoryCombineService());
        new DependencyInjector().doIoc();
        // 依赖注入之后HeadLineShopCategoryCombineService的值不为null
        Assertions.assertNotEquals(null, mainPageController.getHeadLineShopCategoryCombineService());
    }
}
