package AbstractFactory;

/**
 * Button - 按钮抽象类
 * Abstract class for button UI elements
 * 定义按钮的基本行为，继承自 Widget
 */
public abstract class Button extends Widget {
    /**
     * 构造函数
     * Constructor
     * @param text 按钮文本 | Button text
     */
    public Button(String text) {
        super(text);
    }

    /**
     * 显示按钮
     * Display the button using ASCII art
     * 由具体子类实现
     */
    @Override
    public abstract void display();
}

