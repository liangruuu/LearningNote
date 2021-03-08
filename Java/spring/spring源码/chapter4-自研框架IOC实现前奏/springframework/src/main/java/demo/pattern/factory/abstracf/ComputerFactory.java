package demo.pattern.factory.abstracf;

import demo.pattern.factory.entity.Keyboard;
import demo.pattern.factory.entity.Mouse;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/7
 */
public interface ComputerFactory {
    Mouse createMouse();
    Keyboard createKeyboard();
}
