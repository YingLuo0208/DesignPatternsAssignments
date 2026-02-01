package AbstractFactory;

/**
 * CheckboxB - 样式B的复选框
 * Checkbox implementation with Style B (angle brackets)
 * 使用尖括号风格
 */
public class CheckboxB extends Checkbox {
    /**
     * 构造函数
     * Constructor
     * @param text 复选框标签 | Checkbox label
     */
    public CheckboxB(String text) {
        super(text);
    }

    /**
     * 显示样式B的复选框
     * Display checkbox with Style B - angle brackets < >
     * 样式：使用尖括号 < > 表示复选框
     */
    @Override
    public void display() {
        System.out.println("< > " + text);
    }
}

