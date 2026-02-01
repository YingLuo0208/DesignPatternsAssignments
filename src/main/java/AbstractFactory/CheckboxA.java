package AbstractFactory;

/**
 * CheckboxA - 样式A的复选框
 * Checkbox implementation with Style A (square brackets)
 * 使用方括号风格
 */
public class CheckboxA extends Checkbox {
    /**
     * 构造函数
     * Constructor
     * @param text 复选框标签 | Checkbox label
     */
    public CheckboxA(String text) {
        super(text);
    }

    /**
     * 显示样式A的复选框
     * Display checkbox with Style A - square brackets [ ]
     * 样式：使用方括号 [ ] 表示复选框
     */
    @Override
    public void display() {
        System.out.println("[ ] " + text);
    }
}

