import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * 聊天客户端的JavaFX界面
 * 只负责显示和用户输入，不包含任何业务逻辑
 *
 * 实现了 ChatClientController.MessageListener 接口：
 *   当控制器收到消息时，会回调 onMessageReceived() 更新界面
 *
 * 关系示意：
 *   ChatClientGUI → (调用) → ChatClientController → (调用) → ChatMediator
 *   ChatClientGUI ← (回调) ← ChatClientController
 */
public class ChatClientGUI implements ChatClientController.MessageListener {

    /** 绑定的控制器，GUI通过它发送消息 */
    private final ChatClientController controller;

    /** 显示聊天记录的文本区域 */
    private final TextArea chatArea;

    /** 用于选择消息接收方的下拉框 */
    private final ComboBox<String> recipientBox;

    /** 用户输入消息的文本框 */
    private final TextField messageField;

    /**
     * 构造器：创建并展示一个聊天窗口
     *
     * @param controller 对应的客户端控制器
     * @param mediator   Mediator引用，用于获取在线用户列表填充下拉框
     * @param stage      这个窗口使用的JavaFX Stage
     */
    public ChatClientGUI(ChatClientController controller, ChatMediator mediator, Stage stage) {
        this.controller = controller;

        // 将自己注册为控制器的消息监听器
        // 之后控制器收到消息时会调用 onMessageReceived()
        controller.setMessageListener(this);

        // ── 界面组件初始化 ──────────────────────────────────────

        // 聊天记录区域：只读，自动换行
        chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setWrapText(true);
        chatArea.setPrefHeight(300);
        chatArea.setPromptText("Chat history will appear here...");

        // 消息输入框
        messageField = new TextField();
        messageField.setPromptText("Type a message...");
        // 按回车键也可以发送消息
        messageField.setOnAction(e -> handleSend());

        // 收件人下拉框：列出除自己以外的所有已注册用户
        recipientBox = new ComboBox<>();
        recipientBox.setPromptText("Select recipient");
        refreshRecipientList(mediator);

        // 发送按钮
        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> handleSend());

        // ── 布局 ───────────────────────────────────────────────

        // 底部输入区：[收件人下拉框] [消息输入框] [发送按钮]
        HBox inputRow = new HBox(8, recipientBox, messageField, sendButton);
        inputRow.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(messageField, Priority.ALWAYS);

        // 主布局：聊天记录区 + 输入区
        VBox root = new VBox(10, chatArea, inputRow);
        root.setPadding(new Insets(12));
        VBox.setVgrow(chatArea, Priority.ALWAYS);

        // ── 窗口设置 ───────────────────────────────────────────

        Scene scene = new Scene(root, 480, 380);
        stage.setTitle("Chat - " + controller.getUsername());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * 处理发送按钮点击事件
     * GUI只负责从界面取值，实际发送逻辑委托给控制器
     */
    private void handleSend() {
        String recipient = recipientBox.getValue();
        String message   = messageField.getText().trim();

        if (recipient == null || recipient.isBlank()) {
            showAlert("Please select a recipient.");
            return;
        }
        if (message.isBlank()) {
            return;
        }

        // 委托控制器发送，GUI自己不直接联系任何其他控制器
        controller.sendMessage(recipient, message);

        // 清空输入框，准备下一条消息
        messageField.clear();
    }

    /**
     * 实现 MessageListener 接口：当控制器收到新消息时被调用
     * 在聊天记录区追加一行显示
     */
    @Override
    public void onMessageReceived(String from, String message) {
        chatArea.appendText(from + ": " + message + "\n");
    }

    /**
     * 填充收件人下拉框
     * 从Mediator获取所有已注册用户，过滤掉自己
     */
    private void refreshRecipientList(ChatMediator mediator) {
        String self = controller.getUsername();
        for (String user : mediator.getRegisteredUsers()) {
            if (!user.equals(self)) {
                recipientBox.getItems().add(user);
            }
        }
    }

    /**
     * 显示一个简单的警告提示框
     */
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING, message, ButtonType.OK);
        alert.showAndWait();
    }
}
