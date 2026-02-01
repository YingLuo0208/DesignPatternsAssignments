package AbstractFactory;

/**
 * ButtonA - 样式A的按钮
 * Button implementation with Style A (rounded corners with =)
 * 使用圆角风格（使用 = 符号）
 */
public class ButtonA extends Button {
    /**
     * 构造函数
     * Constructor
     * @param text 按钮文本 | Button text
     */
    public ButtonA(String text) {
        super(text);
    }

    /**
     * 显示样式A的按钮
     * Display button with Style A - rounded corners using = and |
     * 样式：使用 = 和 | 绘制圆角边框
     */
    @Override
    public void display() {
        int width = text.length() + 4;
        String horizontalBorder = "=" + "=".repeat(width - 2) + "=";
        String textLine = "| " + text + " |";

        System.out.println(horizontalBorder);
        System.out.println(textLine);
        System.out.println(horizontalBorder);
    }
}

