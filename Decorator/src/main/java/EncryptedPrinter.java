// EncryptedPrinter.java
// 中文注释：
// 一个将消息加密后再打印的装饰器。为了简单起见，这里使用了可逆的移位（凯撒）密码实现，便于演示和解密。
public class EncryptedPrinter extends PrinterDecorator {
    // 移位量，用于简单的加密/解密
    private final int shift;

    /**
     * 构造函数，使用默认移位量 3
     * @param inner 要被装饰的打印器
     */
    public EncryptedPrinter(Printer inner) {
        this(inner, 3);
    }

    /**
     * 构造函数，允许指定移位量
     * @param inner 要被装饰的打印器
     * @param shift  移位量（正整数）
     */
    public EncryptedPrinter(Printer inner, int shift) {
        super(inner);
        this.shift = shift;
    }

    /**
     * 使用简单的凯撒密码对消息进行加密，然后将加密后的消息传递给内部打印器进行输出。
     * @param message 要打印的原始消息
     */
    @Override
    public void print(String message) {
        String encrypted = encrypt(message);
        inner.print(encrypted);
    }

    // 简单的可逆加密：对字母字符进行循环移位，其他字符保持不变
    private String encrypt(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(input.length());
        for (char c : input.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                char e = (char) ((c - 'a' + shift) % 26 + 'a');
                sb.append(e);
            } else if (c >= 'A' && c <= 'Z') {
                char e = (char) ((c - 'A' + shift) % 26 + 'A');
                sb.append(e);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 提供一个公共静态解密方法，用于将加密文本还原为原始文本。
     * @param input 加密文本
     * @return 解密后的原始文本
     */
    public static String decrypt(String input) {
        return decrypt(input, 3);
    }

    /**
     * 使用指定移位量解密文本
     * @param input 加密文本
     * @param shift 移位量
     * @return 解密后的原始文本
     */
    public static String decrypt(String input, int shift) {
        if (input == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(input.length());
        for (char c : input.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                char d = (char) ((c - 'a' - shift + 26) % 26 + 'a');
                sb.append(d);
            } else if (c >= 'A' && c <= 'Z') {
                char d = (char) ((c - 'A' - shift + 26) % 26 + 'A');
                sb.append(d);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
