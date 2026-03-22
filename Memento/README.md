# Memento Pattern - Improved History Functionality
# Memento 设计模式 - 改进的历史记录功能

This directory contains an implementation of the Memento design pattern for a simple graphical application. The application allows users to modify the state of a model (colored boxes and a checkbox) and supports Undo, Redo, and a History Window.
本目录包含一个简单图形应用程序的 Memento（备忘录）设计模式实现。该应用程序允许用户修改模型的状态（彩色方块和复选框），并支持撤销、重做和历史记录窗口。

## Structure | 文件结构

The source code is located in `src/main/java`.
源代码位于 `src/main/java` 中。

-   **Main.java**:
    -   The entry point of the JavaFX application. Initializes the Model, View, and Controller.
    -   JavaFX 应用程序的入口点。初始化模型 (Model)、视图 (View) 和控制器 (Controller)。
-   **Model.java** (Originator | 发起人):
    -   Stores the application state (`boxColors`, `checkBoxState`). Creates and restores Mementos.
    -   存储应用程序状态（`boxColors` 方块颜色, `checkBoxState` 复选框状态）。负责创建和恢复 Mementos（备忘录）。
-   **Gui.java**:
    -   The graphical user interface. Displays the colored boxes and options. Handles user input (clicks, key presses for Undo/Redo).
    -   图形用户界面。显示彩色方块和选项。处理用户输入（点击、用于撤销/重做的按键）。
-   **Controller.java** (Caretaker | 管理者):
    -   Manages the `undoList` and `redoList`. Handles `saveState`, `undo`, `redo`, and interactions with the History Window.
    -   管理 `undoList`（撤销列表）和 `redoList`（重做列表）。处理保存状态、撤销、重做以及与历史记录窗口的交互。
-   **Memento.java**:
    -   Stores a snapshot of the Model's state. Immutable. Implements `IMemento`.
    -   存储模型状态的快照。不可变对象。实现 `IMemento` 接口。
-   **IMemento.java**:
    -   Interface for Memento metadata (timestamp, description).
    -   Memento 元数据（时间戳、描述）的接口。
-   **HistoryWindow.java**:
    -   A separate window displaying the list of saved states. Allows restoring a specific state.
    -   一个单独的窗口，显示已保存状态的列表。允许恢复到特定的状态。
-   **ColorBox.java**:
    -   A custom JavaFX component representing a colored rectangle.
    -   自定义 JavaFX 组件，代表一个彩色矩形。

## Features Implemented | 实现的功能

1.  **Undo/Redo | 撤销/重做**:
    *   **Undo (Ctrl+Z)**: Reverts the model to the previous state.
        *   **撤销 (Ctrl+Z)**：将模型恢复到上一个状态。
    *   **Redo (Ctrl+Y)**: Reapplies the last undone action. The redo list is cleared if a new change occurs.
        *   **重做 (Ctrl+Y)**：重新应用上次撤销的操作。如果发生了新的更改，重做列表将被清空。
2.  **History Window | 历史记录窗口**:
    *   Displays a list of all states in the Undo history.
        *   显示撤销历史记录中所有状态的列表。
    *   Shows metadata (timestamp and description).
        *   显示元数据（时间戳和描述）。
    *   Clicking on a state restores the application to that point in time.
        *   点击某个状态可将应用程序恢复到该时刻。

## Running the Application | 运行应用程序

This project uses Maven and JavaFX.
本项目使用 Maven 和 JavaFX。

To run the application, use the following command in the terminal:
要运行应用程序，请在终端中使用以下命令：

```bash
mvn clean javafx:run
```

Ensure you have a JDK installed that is compatible with JavaFX (JDK 11+ is recommended, project is configured for source/target 17).
请确保您安装了与 JavaFX 兼容的 JDK（推荐 JDK 11+，项目配置为 source/target 17）。
