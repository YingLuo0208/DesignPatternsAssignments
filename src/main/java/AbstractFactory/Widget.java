package AbstractFactory;

/**
 * Widget - UI组件抽象基类
 * Abstract base class for all UI widgets
 * 所有UI组件的通用父类，提供共享的属性和方法
 */
public abstract class Widget {
    /**
     * 组件显示的文本内容
     * Text content displayed in the widget
     */
    protected String text;

    /**
     * 构造函数
     * Constructor
     * @param text 组件文本 | Widget text
     */
    public Widget(String text) {
        this.text = text;
    }

    /**
     * 显示组件
     * Display the widget using ASCII art
     * 由子类实现具体的显示逻辑
     */
    public abstract void display();

    /**
     * 设置组件文本
     * Set the widget text
     * @param text 新的文本内容 | New text content
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 获取组件文本
     * Get the widget text
     * @return 组件文本 | Widget text
     */
    public String getText() {
        return this.text;
    }
}

