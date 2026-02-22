// BasicPrinter.java
// 中文注释：
// 最基础的打印器实现，直接将消息打印到控制台，不做任何装饰或变换。
public class BasicPrinter extends Printer {
    /**
     * 直接在控制台输出原始消息。
     * @param message 要打印的消息文本
     */
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
