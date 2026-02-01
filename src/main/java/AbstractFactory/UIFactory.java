package AbstractFactory;

/**
 * UIFactory - UI工厂抽象类
 * Abstract factory class for creating UI elements
 * 定义创建UI元素的抽象方法
 * 这是抽象工厂模式中的抽象工厂（Abstract Factory）
 */
public abstract class UIFactory {
    /**
     * 创建按钮
     * Create a button with the specified text
     * @param text 按钮文本 | Button text
     * @return 按钮对象 | Button object
     */
    public abstract Button createButton(String text);

    /**
     * 创建文本框
     * Create a text field with the specified text
     * @param text 文本框内容 | Text field content
     * @return 文本框对象 | Text field object
     */
    public abstract TextField createTextField(String text);

    /**
     * 创建复选框
     * Create a checkbox with the specified label
     * @param text 复选框标签 | Checkbox label
     * @return 复选框对象 | Checkbox object
     */
    public abstract Checkbox createCheckbox(String text);
}

