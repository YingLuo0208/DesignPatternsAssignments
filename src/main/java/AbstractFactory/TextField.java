package AbstractFactory;

/**
 * TextField - 文本框抽象类
 * Abstract class for text field UI elements
 * 定义文本框的基本行为，继承自 Widget
 */
public abstract class TextField extends Widget {
    /**
     * 构造函数
     * Constructor
     * @param text 文本框内容 | Text field content
     */
    public TextField(String text) {
        super(text);
    }

    /**
     * 显示文本框
     * Display the text field using ASCII art
     * 由具体子类实现
     */
    @Override
    public abstract void display();
}

