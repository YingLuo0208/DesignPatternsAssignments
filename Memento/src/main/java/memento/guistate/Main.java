package memento.guistate;

//应用程序入口，初始化所有组件

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main application class.
 * Entry point for the application.
 * 主应用程序类。
 * 应用程序的入口点。
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create model, controller, and GUI
        // 创建模型、控制器和 GUI
        Gui gui = new Gui(); // Initialize Gui first

        // Update GUI with controller reference
        // 用控制器引用更新 GUI

        // Update view with initial state
        // 用初始状态更新视图

        gui.start(primaryStage); // Delegate to Gui.start
    }

    public static void main(String[] args) {
        launch(args);
    }
}