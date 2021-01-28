package collections.predecessor;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：     演示Map的基本用法
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        System.out.println(map.isEmpty());
        map.put("东哥", 38);
        map.put("西哥", 28);
        // 返回键的集合["东哥", "西哥"]
        System.out.println(map.keySet());
        // 返回值 28
        System.out.println(map.get("西哥"));
        // map的大小 2
        System.out.println(map.size());
        // 是否包含Key true
        System.out.println(map.containsKey("东哥"));
        map.remove("东哥");
        System.out.println(map.containsKey("东哥"));

    }
}
