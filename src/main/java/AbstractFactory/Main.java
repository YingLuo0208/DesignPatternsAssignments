package AbstractFactory;

/**
 * Main - 主程序类
 * Main application class demonstrating the Abstract Factory pattern
 * 演示抽象工厂模式的主程序
 */
public class Main {
    /**
     * 程序入口
     * Program entry point
     * @param args 命令行参数 | Command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== Abstract Factory Pattern Demo ===");
        System.out.println("=== 抽象工厂模式演示 ===\n");

        // 创建样式A的UI工厂
        // Create Style A UI factory
        System.out.println("--- Style A (Rounded & Simple) ---");
        System.out.println("--- 样式A（圆角和简单风格） ---\n");
        UIFactory factoryA = new AFactory();
        demonstrateUI(factoryA);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 创建样式B的UI工厂
        // Create Style B UI factory
        System.out.println("--- Style B (Bold & Double Line) ---");
        System.out.println("--- 样式B（粗体和双线风格） ---\n");
        UIFactory factoryB = new BFactory();
        demonstrateUI(factoryB);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 演示动态更改文本内容
        // Demonstrate dynamic text change
        System.out.println("--- Demonstrating Dynamic Text Change ---");
        System.out.println("--- 演示动态文本更改 ---\n");
        demonstrateTextChange(factoryA);
    }

    /**
     * 演示使用指定工厂创建UI元素
     * Demonstrate creating UI elements with the specified factory
     * @param factory UI工厂 | UI factory
     */
    private static void demonstrateUI(UIFactory factory) {
        // 创建按钮
        // Create button
        System.out.println("Button | 按钮:");
        Button button = factory.createButton("Click Me");
        button.display();
        System.out.println();

        // 创建文本框
        // Create text field
        System.out.println("TextField | 文本框:");
        TextField textField = factory.createTextField("Enter text here");
        textField.display();
        System.out.println();

        // 创建复选框
        // Create checkbox
        System.out.println("Checkbox | 复选框:");
        Checkbox checkbox1 = factory.createCheckbox("Accept terms");
        checkbox1.display();

        Checkbox checkbox2 = factory.createCheckbox("Subscribe to newsletter");
        checkbox2.display();
    }

    /**
     * 演示动态更改UI元素的文本
     * Demonstrate dynamically changing UI element text
     * @param factory UI工厂 | UI factory
     */
    private static void demonstrateTextChange(UIFactory factory) {
        // 创建按钮并显示
        // Create and display button
        Button button = factory.createButton("Original Text");
        System.out.println("Original button | 原始按钮:");
        button.display();
        System.out.println();

        // 更改文本并再次显示
        // Change text and display again
        button.setText("Updated Text");
        System.out.println("Updated button | 更新后的按钮:");
        button.display();
        System.out.println();

        // 对文本框也进行同样的演示
        // Demonstrate the same with text field
        TextField textField = factory.createTextField("Old content");
        System.out.println("Original text field | 原始文本框:");
        textField.display();
        System.out.println();

        textField.setText("New content");
        System.out.println("Updated text field | 更新后的文本框:");
        textField.display();
    }
}

