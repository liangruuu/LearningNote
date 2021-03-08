package org.simpleframework.util;

import java.util.Collection;
import java.util.Map;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/8
 */
public class ValidationUtil {
    /**
     * Collection是否为null或者size为0
     *
     * @param obj Collection
     * @return 是否为空
     */
    public static boolean isEmpty(Collection<?> obj) {
        return obj == null || obj.isEmpty();
    }

    /**
     * String是否为null或者为""
     *
     * @param obj String
     * @return 是否为空
     */
    public static boolean isEmpty(String obj) {
        return (obj == null || "".equals(obj));
    }

    /**
     * Array是否为null或者为size为0
     *
     * @param obj Array
     * @return 是否为空
     */
    public static boolean isEmpty(Object[] obj) {
        return obj == null || obj.length == 0;
    }

    /**
     * Map是否为null或者为size为0
     * @param obj Map
     * @return 是否为空
     */
    public static boolean isEmpty(Map<?,?> obj){
        return obj == null || obj.isEmpty();
    }
}
