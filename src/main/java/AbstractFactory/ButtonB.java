package AbstractFactory;

/**
 * ButtonB - 样式B的按钮
 * Button implementation with Style B (double line border with #)
 * 使用双线边框风格（使用 # 符号）
 */
public class ButtonB extends Button {
    /**
     * 构造函数
     * Constructor
     * @param text 按钮文本 | Button text
     */
    public ButtonB(String text) {
        super(text);
    }

    /**
     * 显示样式B的按钮
     * Display button with Style B - bold border using # and ||
     * 样式：使用 # 和 || 绘制粗边框
     */
    @Override
    public void display() {
        int width = text.length() + 4;
        String horizontalBorder = "#".repeat(width);
        String textLine = "# " + text + " #";

        System.out.println(horizontalBorder);
        System.out.println(textLine);
        System.out.println(horizontalBorder);
    }
}

