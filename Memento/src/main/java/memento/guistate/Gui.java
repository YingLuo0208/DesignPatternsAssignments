package memento.guistate;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Gui class represents the main application window.
 * It sets up the UI components and handles user interactions.
 * Gui 类代表主应用程序窗口。
 * 它设置 UI 组件并处理用户交互。
 */
public class Gui extends Application {

    private Controller controller; // The controller managing logic // 管理逻辑的控制器
    private ColorBox colorBox1; // First color box // 第一个颜色框
    private ColorBox colorBox2; // Second color box // 第二个颜色框
    private ColorBox colorBox3; // Third color box // 第三个颜色框
    private CheckBox checkBox; // Checkbox for additional option // 额外选项的复选框
    private HistoryWindow historyWindow; // The history window component // 历史记录窗口组件

    /**
     * The main entry point for the JavaFX application.
     * @param stage The primary stage.
     * JavaFX 应用程序的主入口点。
     * @param stage 主舞台。
     */
    public void start(Stage stage) {

        controller = new Controller(this);
        historyWindow = new HistoryWindow(controller);

        Insets insets = new Insets(10, 10, 10, 10);

        // Create three ColorBoxes
        // 创建三个颜色框
        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        // Create a CheckBox
        // 创建复选框
        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        // Add the ColorBoxes to a HBox
        // 将颜色框添加到 HBox
        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);

        hBox.setMargin(colorBox1.getRectangle(), insets);
        hBox.setMargin(colorBox2.getRectangle(), insets);
        hBox.setMargin(colorBox3.getRectangle(), insets);

        // Create buttons for undo, redo, and history
        // 创建撤销、重做和历史记录按钮
        Button undoButton = new Button("Undo (Ctrl+Z)");
        undoButton.setOnAction(event -> controller.undo());

        Button redoButton = new Button("Redo (Ctrl+Y)");
        redoButton.setOnAction(event -> controller.redo());

        Button historyButton = new Button("Show History");
        historyButton.setOnAction(event -> historyWindow.show());

        HBox buttonBox = new HBox(undoButton, redoButton, historyButton);
        buttonBox.setSpacing(10);
        buttonBox.setPadding(insets);

        Label label = new Label("Press Ctrl-Z to undo, Ctrl-Y to redo. Click 'Show History' to view the history window.");
        label.setPadding(insets);
        label.setWrapText(true);

        // Create a VBox that contains everything
        // 创建包含所有内容的 VBox
        VBox vBox = new VBox(hBox, checkBox, buttonBox, label);

        // Handle CheckBox action
        // 处理复选框动作
        checkBox.setOnAction(event -> {
            controller.setIsSelected(checkBox.isSelected());
            updateHistoryDisplay();
        });

        Scene scene = new Scene(vBox);
        // Handle keyboard shortcuts
        // 处理键盘快捷键
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                System.out.println("Undo key combination pressed");
                controller.undo();
            } else if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                System.out.println("Redo key combination pressed");
                controller.redo();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Memento Pattern with Undo/Redo and History");
        stage.setWidth(600);
        stage.setHeight(400);
        stage.show();
    }

    /**
     * Updates the GUI to reflect the current state of the model.
     * 更新 GUI 以反映模型的当前状态。
     */
    public void updateGui() {
        // called after restoring state from a Memento
        // 在从 Memento 恢复状态后调用
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }

    /**
     * Updates the history window display.
     * 更新历史窗口显示。
     */
    public void updateHistoryDisplay() {
        historyWindow.updateHistory();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
