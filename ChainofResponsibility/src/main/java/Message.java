/**
 * 消息类
 * 表示客户反馈消息，包含消息类型、内容和发件人邮箱
 */
public class Message {
    private final MessageType type;      // 消息类型
    private final String content;        // 消息内容
    private final String senderEmail;    // 发件人邮箱

    /**
     * 构造函数
     * @param type 消息类型
     * @param content 消息内容
     * @param senderEmail 发件人邮箱
     */
    public Message(MessageType type, String content, String senderEmail) {
        this.type = type;
        this.content = content;
        this.senderEmail = senderEmail;
    }

    /**
     * 获取消息类型
     * @return 消息类型
     */
    public MessageType getType() {
        return type;
    }

    /**
     * 获取消息内容
     * @return 消息内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 获取发件人邮箱
     * @return 发件人邮箱
     */
    public String getSenderEmail() {
        return senderEmail;
    }

    @Override
    public String toString() {
        return "Message{" +
                "type=" + type +
                ", content='" + content + '\'' +
                ", senderEmail='" + senderEmail + '\'' +
                '}';
    }
}

