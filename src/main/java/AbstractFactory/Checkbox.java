package AbstractFactory;

/**
 * Checkbox - 复选框抽象类
 * Abstract class for checkbox UI elements
 * 定义复选框的基本行为，继承自 Widget
 */
public abstract class Checkbox extends Widget {
    /**
     * 构造函数
     * Constructor
     * @param text 复选框标签 | Checkbox label
     */
    public Checkbox(String text) {
        super(text);
    }

    /**
     * 显示复选框
     * Display the checkbox using ASCII art
     * 由具体子类实现
     */
    @Override
    public abstract void display();
}

