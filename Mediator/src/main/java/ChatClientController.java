/**
 * 客户端控制器，代表一个聊天用户的逻辑层
 * 不包含任何界面代码，只负责业务逻辑
 * 对应ATC例子中的 Aircraft 类
 *
 * 职责：
 *   - 持有对Mediator(ChatServer)的引用，通过它发送消息
 *   - 收到消息后，通知对应的GUI更新显示
 *   - 将自己与GUI解耦：GUI的变化不影响这里的逻辑
 */
public class ChatClientController {

    /** 该用户的唯一用户名 */
    private final String username;

    /**
     * 对Mediator的引用
     * 发消息时调用 mediator.sendMessage()，而不是直接找对方控制器
     * 对应Aircraft中持有的 ATC tower 引用
     */
    private final ChatMediator mediator;

    /**
     * 对GUI的回调接口
     * 使用接口而不是直接引用JavaFX类，保持控制器与界面解耦
     * 当收到消息时，通过这个回调通知GUI刷新显示
     */
    private MessageListener messageListener;

    /**
     * 回调接口定义：GUI实现这个接口，控制器调用它通知界面更新
     * 这是控制器与GUI之间唯一的耦合点，而且方向是单向的
     */
    public interface MessageListener {
        /**
         * 当有新消息需要显示时被调用
         *
         * @param from    发送方标识（如 "Alice" 或 "Me -> Bob"）
         * @param message 消息正文
         */
        void onMessageReceived(String from, String message);
    }

    /**
     * 构造器：创建控制器并立即向Mediator注册自己
     * 对应Aircraft构造时向Tower发出注册请求
     *
     * @param username 用户名
     * @param mediator 中介者引用
     */
    public ChatClientController(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
        // 注册自己，让服务器知道这个用户存在
        mediator.register(this);
    }

    /**
     * 设置GUI回调监听器
     * 在创建GUI之后调用此方法，将界面与控制器绑定
     */
    public void setMessageListener(MessageListener listener) {
        this.messageListener = listener;
    }

    /**
     * 发送消息：将消息委托给Mediator转发
     * 控制器自己不知道接收方在哪里，这是Mediator的职责
     */
    public void sendMessage(String to, String message) {
        if (message == null || message.isBlank()) {
            return;
        }
        // 通过Mediator转发，绝不直接联系对方控制器
        mediator.sendMessage(username, to, message);
    }

    /**
     * 接收消息：由Mediator调用，将消息推送给这个控制器
     * 收到后通知GUI更新显示
     */
    public void receiveMessage(String from, String message) {
        if (messageListener != null) {
            messageListener.onMessageReceived(from, message);
        }
    }

    /**
     * 获取该控制器对应的用户名
     * Mediator用这个方法来路由消息
     */
    public String getUsername() {
        return username;
    }
}
