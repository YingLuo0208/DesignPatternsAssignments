package memento.guistate;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller acts as the Caretaker in the Memento pattern.
 * It manages the history of states (undo/redo) and communicates between the Model and GUI.
 * Controller 在备忘录模式中充当 Caretaker（管理者）。
 * 它管理状态历史（撤销/重做），并在 Model 和 GUI 之间进行通信。
 */
public class Controller {
    private Model model; // Reference to the Model // 模型引用
    private Gui gui; // Reference to the GUI // GUI 引用
    private List<IMemento> undoHistory;  // List to store states for undo // 存储用于撤销的状态列表
    private List<IMemento> redoHistory;  // List to store states for redo // 存储用于重做的状态列表

    /**
     * Constructor for Controller.
     * @param gui The GUI instance.
     * 构造函数。
     * @param gui GUI 实例。
     */
    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.undoHistory = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    /**
     * Sets an option in the model and saves the state.
     * @param optionNumber The index of the option (1-3).
     * @param choice The choice value.
     * 设置模型中的选项并保存状态。
     * @param optionNumber 选项索引 (1-3)。
     * @param choice 选项值。
     */
    public void setOption(int optionNumber, int choice) {
        saveToUndoHistory();
        clearRedoHistory();  // Clear redo history when a new change is made // 进行新更改时清除重做历史
        model.setOption(optionNumber, choice);
    }

    /**
     * Gets an option from the model.
     * @param optionNumber The index of the option.
     * @return The choice value.
     * 从模型获取选项。
     * @param optionNumber 选项索引。
     * @return 选项值。
     */
    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    /**
     * Sets the selected state in the model and saves the state.
     * @param isSelected The new selection state.
     * 设置模型中的选中状态并保存状态。
     * @param isSelected 新的选中状态。
     */
    public void setIsSelected(boolean isSelected) {
        saveToUndoHistory();
        clearRedoHistory();  // Clear redo history when a new change is made // 进行新更改时清除重做历史
        model.setIsSelected(isSelected);
    }

    /**
     * Gets the selected state from the model.
     * @return The selection state.
     * 从模型获取选中状态。
     * @return 选中状态。
     */
    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    // Undo functionality: Ctrl+Z
    // 撤销功能：Ctrl+Z
    public void undo() {
        if (!undoHistory.isEmpty()) {
            System.out.println("Undo: Memento found in undo history");
            // Save current state to redo history before undoing
            // 撤销前将当前状态保存到重做历史
            IMemento currentState = model.createMemento();
            redoHistory.add(currentState);

            // Restore previous state from undo history
            // 从撤销历史恢复前一个状态
            IMemento previousState = undoHistory.remove(undoHistory.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
            gui.updateHistoryDisplay();
        }
    }

    // Redo functionality: Ctrl+Y
    // 重做功能：Ctrl+Y
    public void redo() {
        if (!redoHistory.isEmpty()) {
            System.out.println("Redo: Memento found in redo history");
            // Save current state to undo history before redoing
            // 重做前将当前状态保存到撤销历史
            IMemento currentState = model.createMemento();
            undoHistory.add(currentState);

            // Restore state from redo history
            // 从重做历史恢复状态
            IMemento nextState = redoHistory.remove(redoHistory.size() - 1);
            model.restoreState(nextState);
            gui.updateGui();
            gui.updateHistoryDisplay();
        }
    }

    /**
     * Saves the current model state to the undo history.
     * 保存当前模型状态到撤销历史。
     */
    private void saveToUndoHistory() {
        IMemento currentState = model.createMemento();
        undoHistory.add(currentState);
    }

    /**
     * Clears the redo history.
     * 清除重做历史。
     */
    private void clearRedoHistory() {
        redoHistory.clear();
    }

    // Get the undo history list for the history window
    // 获取用于历史窗口的撤销历史列表
    public List<IMemento> getUndoHistory() {
        return new ArrayList<>(undoHistory);
    }

    // Restore to a specific memento from history
    // 从历史记录恢复到特定的备忘录
    public void restoreToMemento(IMemento memento) {
        // Clear redo history when jumping to a specific state
        // 跳转到特定状态时清除重做历史
        redoHistory.clear();
        model.restoreState(memento);
        gui.updateGui();
        gui.updateHistoryDisplay();
    }
}
