import java.util.ArrayList;
import java.util.List;

/**
 * Mediator的具体实现，扮演"聊天服务器"的角色
 * 负责管理所有已注册的客户端，并在它们之间转发消息
 * 对应ATC例子中的 Tower 类
 *
 * 核心原则：客户端之间永远不直接通信，所有消息都经过这里中转
 */
public class ChatServer implements ChatMediator {

    /**
     * 存储所有已注册的客户端控制器
     * 对应Tower中存储Runway列表的字段
     */
    private final List<ChatClientController> clients = new ArrayList<>();

    /**
     * 注册一个新的客户端控制器
     * 注册后该客户端才能收发消息
     */
    @Override
    public void register(ChatClientController controller) {
        clients.add(controller);
        System.out.println("[Server] Registered user: " + controller.getUsername());
    }

    /**
     * 核心方法：将消息从发送方路由到接收方
     *
     * 流程：
     *   1. 在已注册列表中找到目标用户名对应的控制器
     *   2. 调用目标控制器的 receiveMessage()，把消息"推送"给它
     *   3. 同时也通知发送方自己，让发送方的窗口显示"已发送"记录
     */
    @Override
    public void sendMessage(String from, String to, String message) {
        ChatClientController sender    = findByUsername(from);
        ChatClientController recipient = findByUsername(to);

        if (recipient == null) {
            if (sender != null) {
                sender.receiveMessage("[Server]", "User '" + to + "' not found.");
            }
            return;
        }

        // 通知接收方收到新消息
        recipient.receiveMessage(from, message);

        // 通知发送方：在自己窗口记录这条已发出的消息
        if (sender != null) {
            sender.receiveMessage("Me -> " + to, message);
        }

        System.out.println("[Server] Routed message from " + from + " to " + to);
    }

    /**
     * 返回当前所有已注册用户名的数组
     * 界面用这个列表填充收件人下拉框
     */
    @Override
    public String[] getRegisteredUsers() {
        return clients.stream()
                .map(ChatClientController::getUsername)
                .toArray(String[]::new);
    }

    /**
     * 根据用户名在列表中查找对应的控制器
     */
    private ChatClientController findByUsername(String username) {
        for (ChatClientController c : clients) {
            if (c.getUsername().equals(username)) {
                return c;
            }
        }
        return null;
    }
}
