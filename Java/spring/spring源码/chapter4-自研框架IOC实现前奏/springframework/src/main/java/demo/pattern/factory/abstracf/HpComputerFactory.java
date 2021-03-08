package demo.pattern.factory.abstracf;

import demo.pattern.factory.entity.HpKeyboard;
import demo.pattern.factory.entity.HpMouse;
import demo.pattern.factory.entity.Keyboard;
import demo.pattern.factory.entity.Mouse;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/7
 */
public class HpComputerFactory implements ComputerFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new HpKeyboard();
    }
}
