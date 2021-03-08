package demo.pattern.singleton;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/8
 */
public class StarvingSingleton {
    private static final StarvingSingleton starvingSingleton = new StarvingSingleton();

    private StarvingSingleton() {
    }

    public static StarvingSingleton getInstance() {
        return starvingSingleton;
    }
}
