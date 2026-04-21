/**
 * Mediator接口
 * 定义中介者必须实现的方法，客户端只依赖这个接口，不依赖具体实现
 * 对应ATC例子中的 ATC 接口
 */
public interface ChatMediator {

    /**
     * 注册一个客户端控制器到中介者
     * 对应ATC例子中的 registerRunway()
     */
    void register(ChatClientController controller);

    /**
     * 将消息从发送方转发给接收方
     * 对应ATC例子中的 requestRunway()
     */
    void sendMessage(String from, String to, String message);

    /**
     * 获取当前已注册的所有用户名列表
     * 用于在界面中填充收件人选择框
     */
    String[] getRegisteredUsers();
}
