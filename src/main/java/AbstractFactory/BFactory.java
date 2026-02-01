package AbstractFactory;

/**
 * BFactory - 样式B的UI工厂
 * Concrete factory for creating Style B UI elements
 * 创建样式B的UI元素（粗边框和双线风格）
 * 这是抽象工厂模式中的具体工厂（Concrete Factory）
 */
public class BFactory extends UIFactory {
    /**
     * 创建样式B的按钮
     * Create a Style B button
     * @param text 按钮文本 | Button text
     * @return 样式B的按钮对象 | Style B button object
     */
    @Override
    public Button createButton(String text) {
        return new ButtonB(text);
    }

    /**
     * 创建样式B的文本框
     * Create a Style B text field
     * @param text 文本框内容 | Text field content
     * @return 样式B的文本框对象 | Style B text field object
     */
    @Override
    public TextField createTextField(String text) {
        return new TextFieldB(text);
    }

    /**
     * 创建样式B的复选框
     * Create a Style B checkbox
     * @param text 复选框标签 | Checkbox label
     * @return 样式B的复选框对象 | Style B checkbox object
     */
    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxB(text);
    }
}

