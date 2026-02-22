// PrinterDecorator.java
// 中文注释：
// 抽象装饰器类，持有一个 Printer 引用并将打印请求委托给被装饰的对象。
public abstract class PrinterDecorator extends Printer {
    // 被装饰的打印器对象
    protected final Printer inner;

    /**
     * 构造函数，接收一个要装饰的 Printer 对象。
     * @param inner 要被装饰的打印器
     */
    public PrinterDecorator(Printer inner) {
        this.inner = inner;
    }
}
