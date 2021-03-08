package org.simpleframework.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/8
 */

public class ClassUtilTest {
    @DisplayName("提取目标类方法：extractPackageClassTest")
    @Test
    public void extractPackageClassTest() {
        Set<Class<?>> classSet = ClassUtil.extractPackageClass("club.singlelucky.entity");
        System.out.println(classSet);
        /**
         * club.singlelucky.entity包下目前一共有4个类
         * club.singlelucky.entity.bo.HeadLine
         * club.singlelucky.entity.dto.Result
         * club.singlelucky.entity.dto.MainPageInfoDTO
         * club.singlelucky.entity.bo.ShopCategory
         */
        Assertions.assertEquals(4, classSet.size());
    }
}
