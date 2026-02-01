package AbstractFactory;

/**
 * TextFieldA - 样式A的文本框
 * Text field implementation with Style A (single line border)
 * 使用单线边框风格
 */
public class TextFieldA extends TextField {
    /**
     * 构造函数
     * Constructor
     * @param text 文本框内容 | Text field content
     */
    public TextFieldA(String text) {
        super(text);
    }

    /**
     * 显示样式A的文本框
     * Display text field with Style A - single line border using -
     * 样式：使用 - 和 | 绘制单线边框
     */
    @Override
    public void display() {
        int width = Math.max(text.length(), 10) + 4;
        String horizontalBorder = "+" + "-".repeat(width - 2) + "+";
        String textLine = "| " + text + " ".repeat(width - text.length() - 4) + " |";

        System.out.println(horizontalBorder);
        System.out.println(textLine);
        System.out.println(horizontalBorder);
    }
}

