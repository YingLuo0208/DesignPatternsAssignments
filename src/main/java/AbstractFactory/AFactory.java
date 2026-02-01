package AbstractFactory;

/**
 * AFactory - 样式A的UI工厂
 * Concrete factory for creating Style A UI elements
 * 创建样式A的UI元素（圆角和单线风格）
 * 这是抽象工厂模式中的具体工厂（Concrete Factory）
 */
public class AFactory extends UIFactory {
    /**
     * 创建样式A的按钮
     * Create a Style A button
     * @param text 按钮文本 | Button text
     * @return 样式A的按钮对象 | Style A button object
     */
    @Override
    public Button createButton(String text) {
        return new ButtonA(text);
    }

    /**
     * 创建样式A的文本框
     * Create a Style A text field
     * @param text 文本框内容 | Text field content
     * @return 样式A的文本框对象 | Style A text field object
     */
    @Override
    public TextField createTextField(String text) {
        return new TextFieldA(text);
    }

    /**
     * 创建样式A的复选框
     * Create a Style A checkbox
     * @param text 复选框标签 | Checkbox label
     * @return 样式A的复选框对象 | Style A checkbox object
     */
    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxA(text);
    }
}

