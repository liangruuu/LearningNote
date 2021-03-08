package demo.pattern.factory.method;

import demo.pattern.factory.entity.Mouse;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/7
 */
public class MouseFactoryDemo {
    public static void main(String[] args) {
        HpMousreFactory hpMousreFactory = new HpMousreFactory();
        Mouse mouse = hpMousreFactory.createMouse();
        mouse.sayHi();
    }
}
