package demo.pattern.factory.abstracf;

import demo.pattern.factory.entity.DellKeyboard;
import demo.pattern.factory.entity.DellMouse;
import demo.pattern.factory.entity.Keyboard;
import demo.pattern.factory.entity.Mouse;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/7
 */
public class DellComputerFactory implements ComputerFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new DellKeyboard();
    }
}
