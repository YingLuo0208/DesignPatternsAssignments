// Main.java
// 中文注释：
// 演示装饰器模式的使用：创建基本打印器，并组合 XML 与 加密 装饰器来打印消息。
@SuppressWarnings("unused") // 用于抑制 "类未被使用" 的静态分析警告
public class Main {
    public static void main(String[] args) {
        // 演示1：基础打印器
        System.out.println("=== Basic Printer ===");
        Printer printer = new BasicPrinter();
        printer.print("Hello World!");

        // 演示2：XML 装饰器
        System.out.println("\n=== XML Printer ===");
        Printer xmlPrinter = new XMLPrinter(new BasicPrinter());
        xmlPrinter.print("Hello World!");

        // 演示3：加密装饰器
        System.out.println("\n=== Encrypted Printer ===");
        Printer encryptedPrinter = new EncryptedPrinter(new BasicPrinter());
        encryptedPrinter.print("Hello World!");

        // 演示4：XML + 加密（先 XML 包装，再加密整个结果）
        System.out.println("\n=== XML + Encrypted Printer ===");
        Printer printer2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer2.print("Hello World!");

        // 演示5：加密 + XML（先加密文本，再用 XML 包装加密后的文本）
        System.out.println("\n=== Encrypted + XML Printer (different order) ===");
        Printer printer3 = new XMLPrinter(new EncryptedPrinter(new BasicPrinter()));
        printer3.print("Hello World!");

        // 演示6：解密功能演示
        System.out.println("\n=== Demonstration of Decryption ===");
        String original = "Hello World!";
        String encrypted = "Khoor Zruog!";
        System.out.println("Original: " + original);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + EncryptedPrinter.decrypt(encrypted));
    }
}
