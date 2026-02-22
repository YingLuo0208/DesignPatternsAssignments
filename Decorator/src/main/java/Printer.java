// Printer.java
// 中文注释：
// 抽象的打印机基类，定义了打印器的公共接口。所有具体的打印器和装饰器都应该继承自此类并实现 print 方法。
public abstract class Printer {
    /**
     * 将给定消息以某种格式输出到控制台。
     * @param message 要打印的消息文本
     */
    public abstract void print(String message);
}
