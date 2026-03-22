package memento.guistate;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * HistoryWindow displays the list of past states (history).
 * It allows the user to restore any previous state by clicking on it.
 * HistoryWindow 显示过去状态的列表（历史记录）。
 * 它允许用户通过点击来恢复任何先前的状态。
 */
public class HistoryWindow {
    private Stage stage; // The window stage // 窗口舞台
    private ListView<String> historyListView; // List view to show history items // 用于显示历史记录的列表视图
    private Controller controller; // Reference to the controller // 控制器引用

    /**
     * Constructor for HistoryWindow.
     * @param controller The controller to interact with.
     * 构造函数。
     * @param controller 要交互的控制器。
     */
    public HistoryWindow(Controller controller) {
        this.controller = controller;
        initializeWindow();
    }

    /**
     * Initializes the window components and layout.
     * 初始化窗口组件和布局。
     */
    private void initializeWindow() {
        stage = new Stage();
        stage.setTitle("History Window");
        stage.setWidth(300);
        stage.setHeight(400);

        historyListView = new ListView<>();
        historyListView.setStyle("-fx-font-size: 12;");

        // When user clicks on an item in the list, restore that state
        // 当用户点击列表中的项目时，恢复该状态
        historyListView.setOnMouseClicked(event -> {
            int selectedIndex = historyListView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                IMemento selectedMemento = controller.getUndoHistory().get(selectedIndex);
                controller.restoreToMemento(selectedMemento);
            }
        });

        VBox vBox = new VBox(historyListView);
        vBox.setPadding(new Insets(10));

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
    }

    /**
     * Shows the history window.
     * 显示历史记录窗口。
     */
    public void show() {
        stage.show();
    }

    /**
     * Updates the list of history items from the controller's undo history.
     * 从控制器的撤销历史记录更新历史项目列表。
     */
    public void updateHistory() {
        historyListView.getItems().clear();
        var history = controller.getUndoHistory();
        for (int i = 0; i < history.size(); i++) {
            IMemento memento = history.get(i);
            String description = memento.getDescription();
            historyListView.getItems().add((i + 1) + ". " + description);
        }
    }
}
