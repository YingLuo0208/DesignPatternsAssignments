// XMLPrinter.java
// 中文注释：
// 一个将消息包装为简单 XML 格式的装饰器。例如："Hello" -> <message>Hello</message>
public class XMLPrinter extends PrinterDecorator {

    /**
     * 构造函数，接收要装饰的打印器对象
     * @param inner 要被装饰的打印器
     */
    public XMLPrinter(Printer inner) {
        super(inner);
    }

    /**
     * 将消息包裹在 <message> 标签中，然后委托给内部打印器输出。
     * @param message 要打印的消息文本
     */
    @Override
    public void print(String message) {
        String xml = toXml(message);
        inner.print(xml);
    }

    // 将消息转换为 XML 格式字符串
    private String toXml(String message) {
        if (message == null) {
            message = "";
        }
        // 简单转义：替换 & < > 引号等为实体，避免生成无效 XML
        String escaped = message.replace("&", "&amp;")
                                .replace("<", "&lt;")
                                .replace(">", "&gt;")
                                .replace("\"", "&quot;")
                                .replace("'", "&apos;");
        return "<message>" + escaped + "</message>";
    }
}
