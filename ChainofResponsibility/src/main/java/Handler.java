/**
 * 抽象处理器类
 * 定义了处理客户反馈的接口和责任链管理
 */
public abstract class Handler {
    protected Handler nextHandler;  // 责任链中的下一个处理器

    /**
     * 设置责任链中的下一个处理器
     * @param handler 下一个处理器
     */
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    /**
     * 处理消息的抽象方法
     * 子类必须实现具体的处理逻辑
     * @param message 要处理的消息
     */
    public abstract void handleMessage(Message message);

    /**
     * 将消息传递给责任链中的下一个处理器
     * @param message 要传递的消息
     */
    protected void passToNext(Message message) {
        if (nextHandler != null) {
            nextHandler.handleMessage(message);
        } else {
            System.out.println("No handler found for message type: " + message.getType());
        }
    }
}

