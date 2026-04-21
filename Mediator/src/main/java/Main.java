import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 程序入口
 * 负责创建所有对象并把它们连接在一起：
 *   1. 创建 ChatServer（Mediator）
 *   2. 创建三个 ChatClientController（逻辑层），每个自动注册到Server
 *   3. 创建三个 ChatClientGUI（界面层），每个绑定对应的控制器
 *
 * 注意：JavaFX规定必须继承 Application 并在 start() 中创建 Stage
 * 所有窗口都在同一个JavaFX线程上运行，无需额外线程
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        // ── 第一步：创建Mediator（相当于建立聊天服务器）────────────
        ChatMediator server = new ChatServer();

        // ── 第二步：创建三个用户的控制器 ────────────────────────────
        // 控制器构造时会自动调用 server.register(this)，向服务器注册自己
        ChatClientController aliceCtrl = new ChatClientController("Alice", server);
        ChatClientController bobCtrl   = new ChatClientController("Bob",   server);
        ChatClientController carolCtrl = new ChatClientController("Carol", server);

        // ── 第三步：为每个控制器创建对应的JavaFX窗口 ────────────────
        // primaryStage 是JavaFX自动传入的第一个Stage，给Alice用
        // Bob和Carol各自新建一个Stage
        new ChatClientGUI(aliceCtrl, server, primaryStage);
        new ChatClientGUI(bobCtrl,   server, new Stage());
        new ChatClientGUI(carolCtrl, server, new Stage());
    }

    public static void main(String[] args) {
        // launch() 会初始化JavaFX运行时，然后调用 start()
        launch(args);
    }
}
